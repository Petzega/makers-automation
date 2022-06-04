$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Makers.feature");
formatter.feature({
  "line": 1,
  "name": "Prueba técnica – Automatización",
  "description": "La característica consta de dos escenarios para automatizar, el primero consta de 4 registros que se deben\r\nalmacenar en una base de datos para posteriormente hacer los calculos y cruzar con la información almacenada.\r\nEl segundo escenario consta de un enunciado donde debera acceder a una pagina web y llenar un formulario de contactenos.",
  "id": "prueba-técnica-–-automatización",
  "keyword": "Feature"
});
formatter.background({
  "line": 6,
  "name": "Definir los parametros previos",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "los siguientes parametros de entrada",
  "rows": [
    {
      "cells": [
        "fecha",
        "portafolio",
        "nominal",
        "precio",
        "total"
      ],
      "line": 8
    },
    {
      "cells": [
        "15/05/2020",
        "OBL-MODER",
        "123000",
        "23.65",
        "2908950"
      ],
      "line": 9
    },
    {
      "cells": [
        "15/05/2020",
        "OBL-MODER",
        "10000",
        "25.00",
        "250000"
      ],
      "line": 10
    },
    {
      "cells": [
        "15/05/2020",
        "OBL-RIESGO",
        "1276987",
        "-10.20",
        "-13023267"
      ],
      "line": 11
    },
    {
      "cells": [
        "15/05/2020",
        "OBL-RIESGO",
        "123000",
        "1.29",
        "160670"
      ],
      "line": 12
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "debo insertar los registros en la base datos",
  "keyword": "Then "
});
formatter.match({
  "location": "MakersStepDefinition.losSiguientesParametrosDeEntrada(DataTable)"
});
formatter.result({
  "duration": 12182294900,
  "status": "passed"
});
formatter.match({
  "location": "MakersStepDefinition.deboInsertarLosRegistrosEnLaBaseDatos()"
});
formatter.result({
  "duration": 1907912000,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": ": Primer escenario - Calculos y cruce informacion",
  "description": "",
  "id": "prueba-técnica-–-automatización;:-primer-escenario---calculos-y-cruce-informacion",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "los parametros de entrada previos",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "calcular el valor total asi [nominal * precio]",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "si el portafolio es \"OBL-RIESGO\" se debe calcular el valor total asi [(nominal * precio) + 2000]",
  "keyword": "But "
});
formatter.step({
  "line": 19,
  "name": "validar que el valor total calculado sea igual al campo total de la base de datos",
  "keyword": "And "
});
formatter.match({
  "location": "MakersStepDefinition.losParametrosDeEntradaPrevios()"
});
formatter.result({
  "duration": 1853390100,
  "status": "passed"
});
formatter.match({
  "location": "MakersStepDefinition.calcularElValorTotalAsiNominalPrecio()"
});
formatter.result({
  "duration": 5618467600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "OBL-RIESGO",
      "offset": 21
    },
    {
      "val": "2000",
      "offset": 91
    }
  ],
  "location": "MakersStepDefinition.siElPortafolioEsSeDebeCalcularElValorTotalAsiNominalPrecio(String,int)"
});
formatter.result({
  "duration": 5591065800,
  "status": "passed"
});
formatter.match({
  "location": "MakersStepDefinition.validarQueElValorTotalCalculadoSeaIgualAlCampoTotalDeLaBaseDeDatos()"
});
formatter.result({
  "duration": 1858086700,
  "status": "passed"
});
formatter.background({
  "line": 6,
  "name": "Definir los parametros previos",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "los siguientes parametros de entrada",
  "rows": [
    {
      "cells": [
        "fecha",
        "portafolio",
        "nominal",
        "precio",
        "total"
      ],
      "line": 8
    },
    {
      "cells": [
        "15/05/2020",
        "OBL-MODER",
        "123000",
        "23.65",
        "2908950"
      ],
      "line": 9
    },
    {
      "cells": [
        "15/05/2020",
        "OBL-MODER",
        "10000",
        "25.00",
        "250000"
      ],
      "line": 10
    },
    {
      "cells": [
        "15/05/2020",
        "OBL-RIESGO",
        "1276987",
        "-10.20",
        "-13023267"
      ],
      "line": 11
    },
    {
      "cells": [
        "15/05/2020",
        "OBL-RIESGO",
        "123000",
        "1.29",
        "160670"
      ],
      "line": 12
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "debo insertar los registros en la base datos",
  "keyword": "Then "
});
formatter.match({
  "location": "MakersStepDefinition.losSiguientesParametrosDeEntrada(DataTable)"
});
formatter.result({
  "duration": 10174382200,
  "status": "passed"
});
formatter.match({
  "location": "MakersStepDefinition.deboInsertarLosRegistrosEnLaBaseDatos()"
});
formatter.result({
  "duration": 1864917800,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Segundo escenario - Manejo de selenium",
  "description": "",
  "id": "prueba-técnica-–-automatización;segundo-escenario---manejo-de-selenium",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 22,
  "name": "la siguiente url \"https://somosmakers.co/\"",
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "hacemos clic en el enlace de \"CONTACTO\"",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "capturar el numero de celular de servicio al cliente",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "llenar el formulario \"dejanos un mensaje\" y en el campo mensaje adjuntar el numero de celular capturado",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "antes de hacer clic en el boton \"enviar mensaje\" tomar un pantallazo con la informacion diligenciada",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "https://somosmakers.co/",
      "offset": 18
    }
  ],
  "location": "MakersStepDefinition.laSiguienteUrl(String)"
});
formatter.result({
  "duration": 2252638800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "CONTACTO",
      "offset": 30
    }
  ],
  "location": "MakersStepDefinition.hacemosClicEnElEnlaceDe(String)"
});
formatter.result({
  "duration": 1492726800,
  "status": "passed"
});
formatter.match({
  "location": "MakersStepDefinition.capturarElNumeroDeCelularDeServicioAlCliente()"
});
formatter.result({
  "duration": 31523300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "dejanos un mensaje",
      "offset": 22
    }
  ],
  "location": "MakersStepDefinition.llenarElFormularioYEnElCampoMensajeAdjuntarElNumeroDeCelularCapturado(String)"
});
formatter.result({
  "duration": 704563700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "enviar mensaje",
      "offset": 33
    }
  ],
  "location": "MakersStepDefinition.antesDeHacerClicEnElBotonTomarUnPantallazoConLaInformacionDiligenciada(String)"
});
formatter.result({
  "duration": 82200,
  "status": "passed"
});
});