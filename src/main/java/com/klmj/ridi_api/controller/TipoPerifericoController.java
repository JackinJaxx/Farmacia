package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.persistence.entity.Estado;
import com.klmj.ridi_api.persistence.entity.TipoPerifericos;
import com.klmj.ridi_api.service.TipoPerifericoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/tipo_perifericos")
public class TipoPerifericoController extends PersistenceController<TipoPerifericos, Long>{
    @Autowired
    public TipoPerifericoController(TipoPerifericoService service){super(service);}

    @Override
    @PostMapping
    public ResponseEntity<TipoPerifericos> guardar(@RequestBody TipoPerifericos tipoPerifericos){
        var tipoPerifericoGuardado = super.guardar(tipoPerifericos);
        if(Objects.isNull(tipoPerifericoGuardado.getBody()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try{
            Long idPeriferico = tipoPerifericoGuardado.getBody().getId_tipo_periferico();
            if(idPeriferico != null){
                logger.info("Tipo de periferico %s ha sido guardado correctamente".formatted(tipoPerifericoGuardado));
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
            logger.info("El tipo de periferico no ha podido ser guardado en la base de datos".formatted(tipoPerifericoGuardado.getBody()));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (NullPointerException e){
            logger.info("ocurrió un error inesperado %s"
                    .formatted(e.getMessage()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
