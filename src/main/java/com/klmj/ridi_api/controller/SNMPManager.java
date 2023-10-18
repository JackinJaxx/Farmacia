package com.klmj.ridi_api.controller;
import org.jetbrains.annotations.NotNull;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.Target;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.smi.*;
import org.snmp4j.transport.DefaultUdpTransportMapping;

public class SNMPManager {

    private Snmp snmp;
    private final String address;

    public SNMPManager(String address) {
        this.address = address;
    }

    public void start() throws Exception {
        TransportMapping<UdpAddress> transport = new DefaultUdpTransportMapping();
        snmp = new Snmp(transport);
        transport.listen();
    }

    public String getAsString(OID oid) throws Exception {
        ResponseEvent<Address> event = get(new OID[]{oid});
        if (event != null && event.getResponse() != null && event.getResponse().get(0) != null) {
            return event.getResponse().get(0).getVariable().toString();
        } else {
            // Manejar la situación en la que no se recibe una respuesta válida
            return "No se pudo obtener la respuesta de SNMP";
        }
    }

    public ResponseEvent<Address> get(@NotNull OID @NotNull [] oids) throws Exception {
        PDU pdu = new PDU();
        for (OID oid : oids) {
            pdu.add(new VariableBinding(oid));
        }
        pdu.setType(PDU.GET);
        Target<Address> target = getTarget();
        return snmp.get(pdu, target);
    }

    private @NotNull Target<Address> getTarget() {
        Address targetAddress = GenericAddress.parse(address);
        CommunityTarget<Address> target = new CommunityTarget<>();
        target.setCommunity(new OctetString("public"));
        target.setAddress(targetAddress);
        target.setRetries(2);
        target.setTimeout(1500);
        target.setVersion(org.snmp4j.mp.SnmpConstants.version2c);
        return target;
    }

    public static void main(String[] args) throws Exception {
        SNMPManager client = new SNMPManager("udp:192.168.1.4/161"); // Aquí debes reemplazar la dirección con la IP de la computadora de destino.
        client.start();
        String systemDescription = client.getAsString(new OID(".1.3.6.1.2.1.1.1.0"));
        String systemName = client.getAsString(new OID(".1.3.6.1.2.1.1.5.0"));
        String ram = client.getAsString(new OID(".1.3.6.1.2.1.25.2.2.0"));
        String processor = client.getAsString(new OID("1.3.6.1.4.1.9.9.109.1.1.1.1.24.2"));
        String disk = client.getAsString(new OID("1.3.6.1.4.1.9.9.221.1.1.1.1.20.7000.1"));

        System.out.println("System Description: " + systemDescription);
        System.out.println("System Name: " + systemName);
        System.out.println("RAM: " + ram);
        System.out.println("Processor: " + processor);
        System.out.println("Disk: " + disk);
    }
}