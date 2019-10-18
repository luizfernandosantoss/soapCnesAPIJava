package br.com.cnesAPI.autenticador;


import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Set;

public class HeaderHandlerCnes implements SOAPHandler<SOAPMessageContext> {

    public HeaderHandlerCnes() {

    }

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        Boolean outboundProperty = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if(outboundProperty){
            try {
                SOAPEnvelope envelope =  context.getMessage().getSOAPPart().getEnvelope();
                SOAPHeader header = envelope.getHeader();

                SOAPElement security = header.addChildElement("Security","wsse","http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");

                SOAPElement usernameToken = security.addChildElement("UsernameToken","wsse");

                SOAPElement username = usernameToken.addChildElement("Username","wsse");
                username.addTextNode("CNES.PUBLICO");

                SOAPElement password = usernameToken.addChildElement("Password","wsse");
                password.addTextNode("cnes#2015public");

            } catch (SOAPException e) {
                e.printStackTrace();
            }
        }

        return outboundProperty;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    @Override
    public void close(MessageContext context) {

    }
}