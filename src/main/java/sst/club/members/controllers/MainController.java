package sst.club.members.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import lombok.extern.log4j.Log4j2;
import sst.club.members.main.ClubMembersMain;

@Log4j2
public class MainController {
    private ClubMembersMain owner = null;

    @FXML
    private VBox main;

    public MainController() {
        super();
        log.debug("ClubMembers Controller...");
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        log.debug("initialize...");
        // log.debug("byYearTabController  = " + byYearTabController);
        // log.debug("byMonthTabController = " + byMonthTabController);
        // log.debug("byCategoryController = " + byCategoryTabController);

        // byCategoryTabController.setTitle(StringConstants.BY_CATEGORY);
        // byYearTabController.setListViewData(BankContainer.me().operationsByYear());
        // byMonthTabController.setListViewData(BankContainer.me().operationsByMonth());
        // byCategoryTabController.setTreeViewData(BankContainer.me().getCategories());
    }

    @FXML
    public void update() {
        log.debug("Update...");
    }

    public void setOwner(ClubMembersMain owner) {
        this.owner = owner;
    }

}
