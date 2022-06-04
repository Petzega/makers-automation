package com.makers.automation.stepsDefinitions;

import com.makers.automation.steps.MakersStep;
import cucumber.api.DataTable;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class MakersStepDefinition {
    private WebDriver driver;
    private final MakersStep makersStep = new MakersStep();

////    @Before
//    public void setUp() {
//        System.setProperty("webdriver.chrome.driver",
//                Paths.get("src/test/resources/drivers/chromedriver_102.exe").toString());
//        if (driver == null) {
//            driver = new ChromeDriver();
//        }
//    }
////    @After
//    public void tearDown() {
//        if (driver!=null) {
//            driver.close();
//            driver.quit();
//        }
//    }

    @Given("^los siguientes parametros de entrada$")
    public void losSiguientesParametrosDeEntrada(DataTable dataTable) throws Throwable {
        makersStep.truncateDataBD();
        makersStep.insertDataBD(dataTable);
    }

    @Then("^debo insertar los registros en la base datos$")
    public void deboInsertarLosRegistrosEnLaBaseDatos() throws Throwable {
        makersStep.countDataDB();
    }

    @Given("^los parametros de entrada previos$")
    public void losParametrosDeEntradaPrevios() throws Throwable {
        makersStep.selectDataDB("OBL-MODER");

    }

    @Then("^calcular el valor total asi \\[nominal \\* precio\\]$")
    public void calcularElValorTotalAsiNominalPrecio() throws Throwable {
        makersStep.calcStep("OBL-MODER", 0);
    }

    @But("^si el portafolio es \"([^\"]*)\" se debe calcular el valor total asi \\[\\(nominal \\* precio\\) \\+ (\\d+)\\]$")
    public void siElPortafolioEsSeDebeCalcularElValorTotalAsiNominalPrecio(String portafolio, int adicional) throws Throwable {
        System.out.println("====================");
        makersStep.calcStep(portafolio, adicional);
    }

    @Then("^validar que el valor total calculado sea igual al campo total de la base de datos$")
    public void validarQueElValorTotalCalculadoSeaIgualAlCampoTotalDeLaBaseDeDatos() throws Throwable {
        makersStep.validateCalc();
    }

    @Given("^la siguiente url \"([^\"]*)\"$")
    public void laSiguienteUrl(String URL) throws Throwable {
        makersStep.logIntoSomosMakers(URL);
    }

    @When("^hacemos clic en el enlace de \"([^\"]*)\"$")
    public void hacemosClicEnElEnlaceDe(String data) throws Throwable {
        makersStep.clickBotonContacto(data);
    }

    @Then("^capturar el numero de celular de servicio al cliente$")
    public void capturarElNumeroDeCelularDeServicioAlCliente() throws Throwable {
        makersStep.obtenerCelularContacto();
    }

    @Then("^llenar el formulario \"([^\"]*)\" y en el campo mensaje adjuntar el numero de celular capturado$")
    public void llenarElFormularioYEnElCampoMensajeAdjuntarElNumeroDeCelularCapturado(String arg1) throws Throwable {
        makersStep.completarFormulario();
    }

    @Then("^antes de hacer clic en el boton \"([^\"]*)\" tomar un pantallazo con la informacion diligenciada$")
    public void antesDeHacerClicEnElBotonTomarUnPantallazoConLaInformacionDiligenciada(String arg1) throws Throwable {

    }
}
