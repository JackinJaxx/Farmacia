package com.klmj.ridi_api.service;

import com.klmj.ridi_api.persistence.entity.Usuario;
import com.klmj.ridi_api.persistence.repository.UsuarioRepository;
import org.apache.catalina.User;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Optional;

//Clase que extiende PersistenceController donde se encuentran los metodos CRUD mas comunes
@Service
public class UsuarioService extends PersistenceService<Usuario, Long> {
    @Autowired
    public UsuarioService(UsuarioRepository repository) {
        super(repository);
    }




    /**
     * Metodo que genera una contraseña encriptada
     * Recibe de parametros un String de como escribe la contraseña el usuario
     * y el salt que se genera aleatoriamente
     * Retorna un string de bytes para guardar en la base de datos
     * **/
    public static String hashPasswordWithSalt(String password, String salt) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] saltBytes = salt.getBytes(StandardCharsets.UTF_8);
            byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
            byte[] inputBytes = new byte[saltBytes.length + passwordBytes.length];
            System.arraycopy(saltBytes, 0, inputBytes, 0, saltBytes.length);
            System.arraycopy(passwordBytes, 0, inputBytes, saltBytes.length, passwordBytes.length);
            byte[] hash = digest.digest(inputBytes);
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = String.format("%02x", b);
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Genera un valor aletorio con base 64 cada que se usa y sirve como complemento el metodo hashPasswordWithSalt
    private static String generateSalt() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    /**
     * Metodo que llama a los metodos generateSalt para generar el valor aletorio
     * y pide la contraseña del usuario para pasarla de parametros al metodo
     * hashPasswordWithSalt para generar la contraseña encriptada
     * y la retorna para guardarla en la base de datos
     * **/
    @Override
    public Usuario guardar(@NotNull Usuario user) {
        String salt = generateSalt();
        String password = user.getPassword();
        String hashedPassword = hashPasswordWithSalt(password, salt);
        user.setPassword(hashedPassword);
        user.setSalt(salt);
        return super.guardar(user);
    }



    @Override
    public boolean siExiste(@NotNull Usuario user){
        String paswordTemp = user.getPassword();
        user.setPassword(null);
        Optional<Usuario> usuarioDB = super.buscarPor(user);
        String salt = usuarioDB.get().getSalt();
        String hashedPassword = hashPasswordWithSalt(paswordTemp, salt);
        user.setPassword(hashedPassword);
        return siExiste(user);

    }
}
