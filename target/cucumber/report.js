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
