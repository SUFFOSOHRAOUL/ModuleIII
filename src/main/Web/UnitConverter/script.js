function temperature_Converter(){
    var tempertureInCelscuis = document.getElementById("celsius").value


    var temperatureInFahrenheit = [tempertureInCelscuis*9/5] + 32;
    document.getElementById("fahrenheit").value = temperatureInFahrenheit

}