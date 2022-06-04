package com.makers.automation.paths;

public class MakersPath {

    public String divPage = "//div[@id='et-boc']";
    public String btnContacto = "//ul[@id='menu-principal']//descendant::a[contains(text(), '%s')]";
    public String labelPonteContacto = "//p[contains(text(), 'Ponte en Contacto')]";
    public String textCelularServicio = "//a[@title='celular']";
    public String inpNombre = "//input[@id='et_pb_contact_first_0']";
    public String inpApellido = "//input[@id='et_pb_contact_last_0']";
    public String inpEmail = "//input[@id='et_pb_contact_email_0']";
    public String inpTelefono = "//input[@id='et_pb_contact_phone_0']";
    public String textAreaComentario = "//textarea[@name='et_pb_contact_message_0']";
    public String btnEnviarMensaje = "//button[@name='et_builder_submit_button']";
}
