function validate(){
    var topic = document.getElementById("topic");
    var text = document.getElementById("text");
    var info = document.getElementById("info");

    var topicRegex = /^[A-Z][a-zA-Z0-9]{4,}$/;
    var textRegex = /^[A-Z][a-zA-Z0-9]{9,}$/;

    var result = true;
    var infoResult = "";

    if(!topicRegex.test(topic.value)) {
            infoResult = infoResult + "Nazwa temat posta powinnien składać się z wielkiej litery oraz przynajmniej 5 znaków </br>";
            topic.style.background = "#fcc2c2";
            result = false;
        } else {
            name.style.background = "#ffffff";
        }
      if(!textRegex.test(text.value)) {
                 infoResult = infoResult + "Treść powinna składać się z wielkiej litery oraz przynajmniej 10 znaków";
                 text.style.background = "#fcc2c2";
                 result = false;
             } else {
                 name.style.background = "#ffffff";
             }
     info.innerHTML = infoResult;
        return result;
}