package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class CharacterChoiceTable extends VBox{

	 private TableView<CharacterEntry> tableView;
	    private ProfessorView plantView;

	    public CharacterChoiceTable(ProfessorView plantView) {
	        this.plantView = plantView;

	        // Creazione della TableView
	        tableView = new TableView<>();
	        tableView.setPrefHeight(200);  // Altezza della tabella

	        // Creazione delle colonne della tabella
	        TableColumn<CharacterEntry, String> characterColumn = new TableColumn<>("Character");
	        characterColumn.setCellValueFactory(cellData -> cellData.getValue().characterNameProperty());

	        // Aggiungi le colonne alla TableView
	        tableView.getColumns().add(characterColumn);

	        // Aggiungi i dati dei personaggi alla tabella
	        ObservableList<CharacterEntry> characterData = FXCollections.observableArrayList(
	                new CharacterEntry("Character 1"),
	                new CharacterEntry("Character 2"),
	                new CharacterEntry("Character 3")
	                // Aggiungi altri personaggi se necessario
	        );
	        tableView.setItems(characterData);

	        // Aggiungi un gestore eventi per il cambio del personaggio al clic del mouse sulla tabella
	        tableView.setOnMouseClicked(event -> {
	            CharacterEntry selectedCharacter = tableView.getSelectionModel().getSelectedItem();
	            if (selectedCharacter != null) {
	                plantView.setPlantImage(selectedCharacter.getImagePath());
	            }
	        });

	        // Aggiungi la tabella al layout VBox
	        getChildren().add(tableView);
	    }

	    // Classe di dati per i personaggi
	    public static class CharacterEntry {
	        private final SimpleStringProperty characterName;

	        public CharacterEntry(String characterName) {
	            this.characterName = new SimpleStringProperty(characterName);
	        }

	        public String getCharacterName() {
	            return characterName.get();
	        }

	        public SimpleStringProperty characterNameProperty() {
	            return characterName;
	        }

	        // Restituisci il percorso dell'immagine associato al personaggio
	        public String getImagePath() {
	            // Implementa la logica per ottenere il percorso dell'immagine in base al personaggio
	            // Ad esempio, potresti avere un metodo getImagePath() nella tua classe PlantView
	            // e richiamarlo qui in base al personaggio selezionato.
	            return "path_to_image_based_on_character";
	        }
	    }
}
