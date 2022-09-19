mvn clean javafx:run
============
Attention : avec version récente (pour java 11 ou java 17) de javaFx
les fichiers .fxml ne sont bien trouvés et chargés que si
on les place dans src/main/resources/fxml/xxxx.fxml

et que le chargement soit efectué via un code de ce genre
  FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass()
                .getResource("/fxml/xxxx.fxml"));  // AVEC un / au debut !!!