package org.stepdefination;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.Action;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.pages.LoginPage;
import com.pages.WorkspacePage;
import com.utilities.GlobalLibrary;

import io.cucumber.java.en.*;

public class WorkspaceSteps extends GlobalLibrary {
	WorkspacePage ws = new WorkspacePage();
//	ws = new WorkspacePage();
	LoginPage lp = new LoginPage();
	int itemSize = 0; // change to 14
	int newCount;
	int billingSubscriptionworkspacecount;
	int newBillingSubscriptionworkspacecount;
	int invoiceCountBfBilling;
	int invoiceCountAfBilling;
	String parentTab;

	@When("select admin panel")
	public void select_admin_panel() {
		ws = new WorkspacePage();
		clickbtn(ws.getIcon());
		clickbtn(ws.getAdminpanel());
		siwtchIntoWindow();
	}

	@When("click on workspace setup tab on header")
	public void click_on_workspace_setup_tab_on_header() {
		clickbtn(ws.getWorkspaceSetupHeader());
		itemSize = ws.togetWorkspaceItemCount();
		System.out.println("The count of the workspace is " + itemSize);

	}

	@When("click on Add workspace button")
	public void click_on_Add_workspace_button() {
		clickbtn(ws.getAddworkspaceButton());
	}

	@When("Selects the individual monthly plan")
	public void selects_individual_monthly_plan() throws InterruptedException {
		dropDwoncall(ws.getButtonleftright());
		clickbtn(ws.getButtonleftright());
		System.out.println("Clicked the button 1");
		clickbtn(ws.getIndividualBuyButton());
		System.out.println("Clicked the button ");
	}

	@When("user must make payment with valid card {string},{string},{string},{string}")
	public void user_must_make_payment_with_valid_card(String card, String expiry_date, String cvc, String zone)
			throws InterruptedException {
		System.out.println("check1");

		Set<String> set = driver.getWindowHandles();
		ArrayList<String> list = new ArrayList<>();
		list.addAll(set);
		driver.switchTo().window(list.get(list.size() - 1));
		/*
		 * int count=0; for (String str : set) { count++; if(count==3) {
		 * driver.switchTo().window(str); } }
		 */
		driver.manage().window().maximize();

		WebElement frame = driver.findElement(By.xpath("//iframe[@title='Secure card payment input frame']"));

		driver.switchTo().frame(frame);
		sendKeyCall(ws.getCardnumber(), card);
		sendKeyCall(ws.getExpdate(), expiry_date);
		sendKeyCall(ws.getCvc(), cvc);
		sendKeyCall(ws.getZip(), zone);
		driver.switchTo().defaultContent();
		clickbtn(ws.getPlaceOrder());
		driver.findElement(By.xpath("//button[contains(text(),'Close')]")).click();
		// driver.close();
		driver.switchTo().window(list.get(list.size() - 2));

	}

	@Then("verify the last workspace added")
	public void verify_the_last_workspace_added() throws InterruptedException {
		Thread.sleep(5000);
		clickbtn(ws.getWorkspaceSetupHeader());
		newCount = ws.togetWorkspaceItemCount();
		System.out.println("Get workspace Item count after add : " + newCount);
		// Assert.assertTrue("item count mismatched ", newCount > itemSize);
//		driver.close();
	}

	@When("User clicks the change password icon in the admin panel")
	public void user_clicks_the_change_password_icon_in_the_admin_panel() {
		clickbtn(ws.getIcon());
		clickbtn(ws.getPasswordReset());

	}

	@When("User enters the existing and new password {string} {string}")
	public void user_enters_the_existing_and_new_password(String oldPassword, String newPassword) {

		sendKeyCall(ws.getExistPassword(), oldPassword);
		sendKeyCall(ws.getNewPassword(), newPassword);
		sendKeyCall(ws.getConfirmPassword(), newPassword);
		clickbtn(ws.getPasswordResetSubmit());
	}

	@When("User clicks the logout")
	public void user_clicks_the_logout() {
		clickbtn(ws.getIcon());
		clickbtn(ws.getSignOut());

	}

	@When("User validates the username {string}")
	public void user_validates_the_username(String userName) throws InterruptedException {
		String userNameValidate = getAttributcall(lp.getUserNameValidate(), "title");
		System.out.println("User Name : " + userNameValidate);
		Assert.assertEquals(userNameValidate, userName);
	}

	// // --------------------BILLING -
	// WORKSPACE------------------------------------------------------

	@When("User selects the subscription from Billing")
	public void user_selects_the_subscription_from_Billing() {

		clickbtn(ws.getBillingOption());
		// dropDownVisibleTextCall(ws.getBillingOption(),"Subscription");
		clickbtn(ws.getDropdownBillingOptionSubscription());
		billingSubscriptionworkspacecount = ws.getBillingSubscriptionWorkspacesItemCount();
	}

	@When("User clicks the add workspace from the subscription of the Billing header")
	public void user_clicks_the_add_workspace_from_the_subscription_of_the_Billing_header() {

		clickbtn(ws.getBillingSubscriptionAddWorkspace());
	}

	@Then("verify the last workspace added for Billing Subscriptions")
	public void verify_the_last_workspace_added_for_Billing_Subscriptions() {
		newBillingSubscriptionworkspacecount = ws.getBillingSubscriptionWorkspacesItemCount();
		System.out.println("New Billing Subscription Workspace : " + newBillingSubscriptionworkspacecount);
		Assert.assertFalse("item count mismatched : ",
				newBillingSubscriptionworkspacecount > billingSubscriptionworkspacecount);
		// driver.close();
	}

	// -------------------------------------------------------------------------------------------------

	// // ---------------------CLUSTER TEAM +
	// --------------------------------------------
	@When("User click the Team plus icon in the workspace setup")
	public void user_click_the_Team_plus_icon_in_the_workspace_setup() {

		clickbtn(ws.getTeamPlus());
	}

	@When("User clicks the edit icon in the Team plus")
	public void user_clicks_the_edit_icon_in_the_Team_plus() {
		clickbtn(ws.getTeamPlusEdit());
	}

	@When("User deletes the existing clusters and add three new clusters")
	public void user_deletes_the_existing_clusters_and_add_three_new_clusters(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {

		System.out.println("Delete Icon Count : " + ws.getTeamPlusclusterDeleteAllCount());
		List<String> l = dataTable.asList();
		int listSize = l.size();
		System.out.println("List size : " + listSize);
		boolean deleteIcon = (ws.getTeamPlusclusterDeleteAllCount() == 0);
		if (deleteIcon == true) {
			for (int i = 0; i < listSize; i++) {
				System.out.println(i + ":" + l.get(i));
				sendKeyCall(ws.getClusterName(), l.get(i));
				clickbtn(ws.getClusterNameAdd());
				Thread.sleep(2000);
			}
		} else {
			for (int i = 0; i <= ws.getTeamPlusclusterDeleteAllCount() + 1; i++) {
				System.out.println("Delete Icon Count Before : " + ws.getTeamPlusclusterDeleteAllCount());
				Thread.sleep(2000);
				dropDwoncall(ws.getTeamPlusclusterDelete());
				clickbtn(ws.getTeamPlusclusterDelete());
				alertAcceptCall();
				Thread.sleep(2000);
			}
			for (int i = 0; i < listSize; i++) {
				System.out.println(i + ":" + l.get(i));
				sendKeyCall(ws.getClusterName(), l.get(i));
				clickbtn(ws.getClusterNameAdd());
				Thread.sleep(2000);
			}
			// }
			if (ws.getTeamPlusclusterDeleteAllCount() == 3) {
				Thread.sleep(2000);
				System.out.println("ADD ICON COUNT : " + ws.getClusterNameAddListCount());
				String addWorkspaceIcon = "//button[contains(text(),'Add')]";
				invisibilityOfElementLocated(10, 1, addWorkspaceIcon);
				invisibilityOf(5, 1, ws.getClusterNameAdd(), "");
				Boolean addIconpresent = driver.findElement(By.xpath(addWorkspaceIcon)).isDisplayed();
				Assert.assertFalse("Add icon present : ", addIconpresent);
			}
		}

	}

	// -------------------------------------------------------------------------------------------------

	@When("User clicks the gear icon in the cluster to add fields {string}")
	public void user_clicks_the_gear_icon_in_the_cluster_to_add_fields(String clusterName) throws InterruptedException {
//		for (int i = 0; i < ws.getClusterNameAllCount(); i++) {
//			int count = i;
//			String clusterNameGet = getTextCall(ws.getClusterName());
//			System.out.println(i + " : " + clusterNameGet);
//			if (clusterNameGet == clusterName) {
//				String gearIcon = "//span[@title='Go to settings Workspace'][" + count + "]";
//				WebElement gearIconclick = driver.findElement(By.xpath(gearIcon));
		String gearIcon = "//span[text()='" + clusterName + "']/following::span[@title='Go to settings Workspace']";
		WebElement gearIconclick = driver.findElement(By.xpath(gearIcon));
		clickbtn(gearIconclick);
		Thread.sleep(1000);
		// }
		// }
	}

	@When("User clicks adds the fied in the cluster")
	public void user_clicks_adds_the_fied_in_the_cluster(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {

		List<String> l = dataTable.asList();
		int listSize = l.size();
		System.out.println("List size : " + listSize);

		for (int i = 0; i < listSize; i++) {
			clickbtn(ws.getExtractionAddField());
			System.out.println(i + ":" + l.get(i));
			sendKeyCall(ws.getExtractionFieldName(), l.get(i));
			sendKeyCall(ws.getExtractionFieldDescription(), l.get(i));
			clickbtn(ws.getExtractionFieldSave());
			Thread.sleep(2000);
		}
	}

	@When("user validates the add field after adding all fields")
	public void user_validates_the_add_field_after_adding_all_fields() {
		visibilityOf(5, 1, ws.getExtractionFieldFull(), "");
		String addIconExtraction = "//h4[contains(text(),'Extraction Fields')]/following::button[contains(text(),'Add Field')]";

		WebElement addIcon_Extraction = driver.findElement(
				By.xpath("//h4[contains(text(),'Extraction Fields')]/following::button[contains(text(),'Add Field')]"));
		addIcon_Extraction.isEnabled();
		Boolean addIconAvailable = driver.findElement(By.xpath(addIconExtraction)).isEnabled();
		Assert.assertFalse("add Icon for Extraction field is : ", addIconAvailable);
//		Assert.assertFalse("add Icon for Extraction field is : ", elementIsEnabled(ws.getExtractionAddField()));		
	}

	// // ------------------------ ADD FIELD WORKSPACE SETUP-----------------------
	@When("User click the Team icon in the workspace setup")
	public void user_click_the_Team_icon_in_the_workspace_setup() {

		clickbtn(ws.getTeam());
	}

// // -----------------------TEAM USER ASSIGNMENT---------------
	@When("User deletes and selects the users from the user assignment")
	public void user_deletes_and_selects_the_users_from_the_user_assignment(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {

		List<String> l = dataTable.asList();
		int listSize = l.size();
		System.out.println("List size : " + listSize);
		Thread.sleep(2000);
		System.out.println("Remove Icon count before Adding : " + ws.getRemoveUserAssignmentAllCount());
		if (ws.getRemoveUserAssignmentAllCount() == 0) {
			for (int i = 0; i < listSize; i++) {
				javaScriptExecutorScrollTopcall(ws.getUserAssignmentDropDown());
				dropDownVisibleTextCall(ws.getUserAssignmentDropDown(), l.get(i));
				Thread.sleep(2000);
				clickbtn(ws.getAssignUserAssignment());
			}
		} else {
			for (int i = 0; i <= ws.getRemoveUserAssignmentAllCount(); i++) {
				System.out.println("Delete Icon Count Before : " + ws.getRemoveUserAssignmentAllCount());
				Thread.sleep(2000);
				javaScriptExecutorScrollTopcall(ws.getRemoveUserAssignment());
				dropDwoncall(ws.getRemoveUserAssignment());
				clickbtn(ws.getRemoveUserAssignment());
				Thread.sleep(2000);
			}
			for (int i = 0; i < listSize; i++) {
				javaScriptExecutorScrollTopcall(ws.getUserAssignmentDropDown());
				dropDownVisibleTextCall(ws.getUserAssignmentDropDown(), l.get(i));
				Thread.sleep(2000);
				clickbtn(ws.getAssignUserAssignment());
			}
		}
		Thread.sleep(2000);
		System.out.println("Total user Assigned : " + ws.getAllUsersAssignedCount());
		Assert.assertTrue("Total Number of Usrers created is Equal", ws.getAllUsersAssignedCount() == l.size());
	}

	@When("user validates the user assign field after adding three fields")
	public void user_validates_the_user_assign_field_after_adding_three_fields() {

		String assignIcon = "//button[contains(text(),'Assign')]";
		Boolean addIconAvailable = driver.findElement(By.xpath(assignIcon)).isDisplayed();
		System.out.println("ADD ICON : " + addIconAvailable);
		Assert.assertFalse("add Icon for Extraction field is : ", addIconAvailable);
	}

	// // ----------------------------------- TEST CASE
	// 17--------------------------------

	@When("User clicks the edit icon of last workspace created")
	public void user_clicks_the_edit_icon_of_last_workspace_created() {
		clickbtn(ws.getLastWorkSpaceCreated());
	}

	@When("User edits the name of the workspace {string}")
	public void user_edits_the_name_of_the_workspace(String workSpaceName) {
		clickbtn(ws.getWorkspaceNameEdit());
		clear(ws.getWorkspaceNameEditText());
		sendKeyCall(ws.getWorkspaceNameEditText(), workSpaceName);
		clickbtn(ws.getWorkspaceNameUpdate());

	}

	@When("User clicks the Activate in the workspace")
	public void user_clicks_the_Activate_in_the_workspace() {
		clickbtn(ws.getWorkspaceActivateIcon());
	}

	@When("User checks for the alert for the unassigned user")
	public void user_checks_for_the_alert_for_the_unassigned_user() {
//		alertGetTextPrint("Incomplete configuration. Please check below components!!\r\n" + "Fields");
//		alertAcceptCall();
		clickbtn(ws.getButtonOk());
	}

	@When("User checks the checkbox in the alert and clicks activate")
	public void user_checks_the_checkbox_in_the_alert_and_clicks_activate() throws InterruptedException {
		Thread.sleep(3000);
		clickbtn(ws.getAgreeCheckBox());
		clickbtn(ws.getActivateWorkspace());
	}

	@When("user validates the active status")
	public void user_validates_the_active_status() {
		String status = getTextCall(ws.getActiveStatusWorkspace());
		Assert.assertEquals(status, "ACTIVE");
	}

	@When("Selects the monthly team plus plan")
	public void selects_the_monthly_team_plus_plan() {
		dropDwoncall(ws.getButtonleftright());
		clickbtn(ws.getButtonleftright());
		clickbtn(ws.getTeamPlusBuy());
	}

	// -----------------------------------------------------------
	@When("User edits the activated field")
	public void user_edits_the_activated_field() {
		String editField = "//a[@class='action_btn not-active']//i[@title='Edit']";
		WebElement editIcon = driver.findElement(By.xpath(editField));
		elementToBeClickable(5, 1, editIcon, editField);
		System.out.println("Present : " + editIcon.isEnabled());
		// Assert.assertFalse("Delete Icon Not Enabled", editIcon.isEnabled());
	}

	@When("User deletes the activated field")
	public void user_deletes_the_activated_field() {
		String fieldDelete = "//a[@class='delete action_btn not-active']//i[@title='Delete']";
		WebElement deleteIcon = driver.findElement(By.xpath(fieldDelete));
		elementToBeClickable(5, 1, deleteIcon, fieldDelete);
		// deleteIcon.click();
//		Assert.assertFalse("Delete Icon Not Enabled", deleteIcon.isEnabled());
	}

	@When("User clicks the edit icon for the workspace {string}")
	public void user_clicks_the_edit_icon_for_the_workspace(String workspaceName) {

		String workSpaceEditIcon = "//h4[text()='" + workspaceName + "']/following::i[contains(@class,'fas fa-edit')]";
		WebElement element = driver.findElement(By.xpath(workSpaceEditIcon));
		element.click();
	}

	// // --------------------------TC 21------------------------------

	@When("User clicks the add template icon")
	public void user_clicks_the_add_template_icon() {
		clickbtn(ws.getAddTemplate());
	}

	@When("user saves the template name and description {string} {string}")
	public void user_saves_the_template_name_and_description(String templateName, String templateDec) {
		sendKeyCall(ws.getAddTemplateName(), templateName);
		sendKeyCall(ws.getAddTemplateName(), templateDec);
		clickbtn(ws.getTemplateSave());
	}

	@When("User clicks the build template")
	public void user_clicks_the_build_template() {
		clickbtn(ws.getBuildTemplate());
	}

	@When("User clicks the edit icon on the corresponding column of the template")
	public void user_clicks_the_edit_icon_on_the_corresponding_column_of_the_template() {
		clickbtn(ws.getTemplateFieldEdit());
	}

	@When("User clicks the add segment icon")
	public void user_clicks_the_add_segment_icon() {
		clickbtn(ws.getAddSegmentIcon());
	}

	@When("User selects the transformation and extraction field")
	public void user_selects_the_transformation_and_extraction_field(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {
		List<String> l = dataTable.asList();
		int listSize = l.size();
		System.out.println("List size : " + listSize);

		for (int i = 0; i < listSize; i++) {
			switch (l.get(i)) {
			case "Bookmark":
				dropDownVisibleTextCall(ws.getTransformationDropDown(), l.get(i));
				dropDownVisibleTextCall(ws.getSegmentListDropDown(), l.get(i + 1));
				break;

			case "Currency":
				dropDownVisibleTextCall(ws.getTransformationDropDown(), l.get(i));
				dropDownVisibleTextCall(ws.getSegmentListDropDown(), l.get(i + 1));
				dropDownVisibleTextCall(ws.getSegmenParametDropDown(), l.get(i + 2));
				break;

			case "Date":
				dropDownVisibleTextCall(ws.getTransformationDropDown(), l.get(i));
				dropDownVisibleTextCall(ws.getSegmentListDropDown(), l.get(i + 1));
				dropDownVisibleTextCall(ws.getSegmenParametDropDown(), l.get(i + 2));
				break;

			case "Document Details":
				dropDownVisibleTextCall(ws.getTransformationDropDown(), l.get(i));
				dropDownVisibleTextCall(ws.getSegmentListDropDown(), l.get(i + 1));
				break;

			case "Original Value text":
				dropDownVisibleTextCall(ws.getTransformationDropDown(), l.get(i));
				dropDownVisibleTextCall(ws.getSegmentListDropDown(), l.get(i + 1));
				break;

			case "Custom text":
				dropDownVisibleTextCall(ws.getTransformationDropDown(), l.get(i));
				sendKeyCall(ws.getTemplateCustomText(), l.get(i + 1));
				break;

			case "Language code":
				dropDownVisibleTextCall(ws.getTransformationDropDown(), l.get(i));
				break;

			case "Numerical value":
				dropDownVisibleTextCall(ws.getTransformationDropDown(), l.get(i));
				dropDownVisibleTextCall(ws.getSegmentListDropDown(), l.get(i + 1));
				dropDownVisibleTextCall(ws.getSegmenParametDropDown(), l.get(i + 2));
				break;

			default:
				break;
			}

		}
	}

	@When("User clicks the create icon")
	public void user_clicks_the_create_icon() {
		clickbtn(ws.getTemplateBuilderCreate());
	}

	@When("User clicks the user setup on header of the dashboard")
	public void user_clicks_the_user_setup_on_header_of_the_dashboard() {
		clickbtn(ws.getUserSetup());
	}

	@When("User clicks the create new user icon")
	public void user_clicks_the_create_new_user_icon() throws InterruptedException {
		elementToBeClickable(10, 1, ws.getCreateNewUser(), "");
		Thread.sleep(3000);
		clickbtn(ws.getCreateNewUser());
	}

	@When("User enters the name,email and employee id {string} {string} {string}")
	public void user_enters_the_name_email_and_employee_id(String name, String email, String employeeId) {
		sendKeyCall(ws.getUserSetupName(), name);
		sendKeyCall(ws.getUserSetupEmail(), email);
		sendKeyCall(ws.getUserSetupEmployeeId(), employeeId);
	}

	@When("User selects the active or Inactive state {string}")
	public void user_selects_the_active_or_Inactive_state(String state) {
		if (state.equalsIgnoreCase("inactive")) {
			clickbtn(ws.getInactiveButton());
		} else {
			clickbtn(ws.getActiveButton());
		}

	}

	@When("User clicks the save button")
	public void user_clicks_the_save_button() {
		clickbtn(ws.getTemplateSave());
	}

	@When("User clicks the edit button {string}")
	public void user_clicks_the_edit_button(String email) throws InterruptedException {
		Thread.sleep(2000);
		String userSetipEditIcon = "//td[text()='" + email
				+ "']/following::a[@class='edit action_btn']//i[@title='Edit']";
		WebElement userSetupEdit = driver.findElement(By.xpath(userSetipEditIcon));
		clickbtn(userSetupEdit);
	}

	@When("User edits the user name and employee id of the user setup {string} {string}")
	public void user_edits_the_user_name_and_employee_id_of_the_user_setup(String nameEdit, String employeeIdEdit) {
		clear(ws.getUserSetupName());
		sendKeyCall(ws.getUserSetupName(), nameEdit);
		clear(ws.getUserSetupEmployeeId());
		sendKeyCall(ws.getUserSetupEmployeeId(), employeeIdEdit);
	}

	@When("User clicks the checkbox to make the user active {string}")
	public void user_clicks_the_checkbox_to_make_the_user_active(String email) throws InterruptedException {
		Thread.sleep(3000);
		String userSetupCheckActive = "//td[text()='" + email
				+ "']/following::td[text()='INACTIVE']/following::a[@class='activate action_btn']//i[@title='Activate']";
		WebElement userSetUpActivate = driver.findElement(By.xpath(userSetupCheckActive));
		clickbtn(userSetUpActivate);
	}

	@When("User clicks the checkbox to make the user inactive {string}")
	public void user_clicks_the_checkbox_to_make_the_user_inactive(String email) throws InterruptedException {
		Thread.sleep(3000);
		String userSetupCheckActive = "//td[text()='" + email
				+ "']/following::td[text()='ACTIVE']/following::a[@class='deactivate action_btn']//i[@title='Deactivate']";
		WebElement userSetUpActivate = driver.findElement(By.xpath(userSetupCheckActive));
		clickbtn(userSetUpActivate);
	}

	@When("User clicks the invoice in the billing")
	public void user_clicks_the_invoice_in_the_billing() throws InterruptedException {
		visibilityOf(10, 1, ws.getBillingOption(), "");
		elementToBeClickable(10, 1, ws.getBillingOption(), "");
		clickbtn(ws.getBillingOption());
		clickbtn(ws.getInvoiceBilling());
	}

	@When("User gets the invoice count before billing")
	public void user_gets_the_invoice_count_before_billing() throws InterruptedException {
		Thread.sleep(3000);
		invoiceCountBfBilling = ws.getInvoiceRowsCount();
		System.out.println("Invoice count : " + invoiceCountBfBilling);
	}

	@When("User validates the invoice after billing")
	public void user_validates_the_invoice_after_billing() throws InterruptedException {
		Thread.sleep(3000);
		invoiceCountAfBilling = ws.getInvoiceRowsCount();
		System.out.println("Invoice count : " + invoiceCountAfBilling);
		Assert.assertTrue("Invoice count is greater ", invoiceCountAfBilling > invoiceCountBfBilling);
	}

	@When("User clicks the dropdown of the workspace in the subscription")
	public void user_clicks_the_dropdown_of_the_workspace_in_the_subscription() {
		clickbtn(ws.getSubscriptionLastUserDropDown());
	}

	@When("User upgrades the subscription plan {string}")
	public void user_upgrades_the_subscription_plan(String plan) throws InterruptedException {

		dropDownVisibleTextCall(ws.getSubscriptionProductDropDown(), plan);
	}

	@When("User clicks update and confirm the subscription")
	public void user_clicks_update_and_confirm_the_subscription() throws InterruptedException {
		clickbtn(ws.getSubscriptionUpdate());
		Thread.sleep(5000);
		visibilityOf(10, 1, ws.getSubscriptionUpdateConfirm(), "");
		elementToBeClickable(10, 1, ws.getSubscriptionUpdateConfirm(), "");
		clickbtn(ws.getSubscriptionUpdateConfirm());

	}

	@When("user clicks the go back after subscription")
	public void user_clicks_the_go_back_after_subscription() throws InterruptedException {
		Thread.sleep(3000);
		visibilityOf(10, 1, ws.getSubscriptionUpgradeMessage(), "");
		visibilityOf(10, 1, ws.getSubscriptionGoBack(), "");
		elementToBeClickable(10, 1, ws.getSubscriptionGoBack(), "");
//		clickbtn(ws.getSubscriptionGoBack());
		javaScriptExecutorClickcall(ws.getSubscriptionGoBack());
		Thread.sleep(3000);
	}

	@When("User upgrades the cycle of the subscription {string}")
	public void user_upgrades_the_cycle_of_the_subscription(String cycle) throws InterruptedException {
		dropDownVisibleTextCall(ws.getSubscriptionCycleDropDown(), cycle);
	}

	@When("User clicks the cancel after clicks the product dropdown in subscription")
	public void user_clicks_the_cancel_after_clicks_the_product_dropdown_in_subscription() throws InterruptedException {
		javaScriptExecutorScrollTopcall(ws.getSubscriptionProductDropDown());
		clickbtn(ws.getSubscriptionProductDropDown());
		dropDwoncall(ws.getCancelButton());
		clickbtn(ws.getCancelButton());
		Thread.sleep(2000);
		Assert.assertFalse("Dropdown disabled ", ws.getSubscriptionProductDropDown().isEnabled());
	}

	@When("User clicks the documents from operatios on header")
	public void user_clicks_the_documents_from_operatios_on_header() {
		clickbtn(ws.getOperationsHeader());
		clickbtn(ws.getDocumentsOperationsHeader());
	}

	@When("User clicks upload button in the documents")
	public void user_clicks_upload_button_in_the_documents() throws InterruptedException {
		Thread.sleep(2000);
		clickbtn(ws.getDocumentUpload());
	}

	@When("User clicks upload button in the extraction page")
	public void user_clicks_upload_button_in_the_extraction_page() throws InterruptedException {
		Thread.sleep(2000);
		clickbtn(ws.getUploadExtractPage());
	}

	@When("User uploads the file in the extraction page{string}")
	public void user_uploads_the_file_in_the_extraction_page(String fileName)
			throws InterruptedException, AWTException {
		String currentDirectory = System.getProperty("user.dir");
		System.out.println("The current working directory is " + currentDirectory);

		// C:\Users\TEST\Downloads\NeoXtractzip\NeoXtract\src\test\resources\Files\Untitled_spreadsheet.pdf
		String filePath = currentDirectory + "\\src\\test\\resources\\Files\\" + fileName;
		System.out.println("File Path : " + filePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection str = new StringSelection(filePath);
		clipboard.setContents(str, null);

		Thread.sleep(2000);
		String upload_xpath = "//div[@class='dropzone-custom-content dz-message']//i[@class='file_upload_icon']";
		WebElement element = driver.findElement(By.xpath(upload_xpath));
		element.click();
		Thread.sleep(3000);
		robotPASTECall();
		Thread.sleep(1000);
		robotENTERCall();

	}

	@When("User uploads the file in the documents{string}")
	public void user_uploads_the_file_in_the_documents(String fileName) throws InterruptedException, AWTException {
		String currentDirectory = System.getProperty("user.dir");
		System.out.println("The current working directory is " + currentDirectory);

		// C:\Users\TEST\Downloads\NeoXtractzip\NeoXtract\src\test\resources\Files\Untitled_spreadsheet.pdf
		String filePath = currentDirectory + "\\src\\test\\resources\\Files\\" + fileName;
		System.out.println("File Path : " + filePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection str = new StringSelection(filePath);
		clipboard.setContents(str, null);

		Thread.sleep(2000);
		String upload_xpath = "//div[@class='col-lg-6']//div[@id='drag_and_drop_section']//i[@class='file_upload_icon']";
		WebElement element = driver.findElement(By.xpath(upload_xpath));
		element.click();
		Thread.sleep(3000);
		robotPASTECall();
		Thread.sleep(1000);
		robotENTERCall();
	}

	@When("User enters the country,publish year,language,document type and publisher name {string} {string} {string} {string} {string}")
	public void user_enters_the_country_publish_year_language_document_type_and_publisher_name(String country,
			String publishYear, String language, String documentType, String publisherName) {

		sendKeyCall(ws.getUploadCountry(), country);
		String selectCountry = "//li[text()='" + country + "']";
		clickbtn(customXpath(selectCountry));
		sendKeyCall(ws.getUploadPublishYear(), publishYear);
		sendKeyCall(ws.getUploadLanguage(), language);
		String selectLang = "//li[text()='" + language + "']";
		clickbtn(customXpath(selectLang));
		sendKeyCall(ws.getUploadDocumentType(), documentType);
		sendKeyCall(ws.getUploadPublisherName(), publisherName);
	}

	@When("User clicks upload and close")
	public void user_clicks_upload_and_close() throws InterruptedException {
		Thread.sleep(3000);
		clickbtn(ws.getUploadAndClose());
		Thread.sleep(5000);
	}

	@When("User selects the workspace from the dropdown in extraction homepage {string}")
	public void user_selects_the_workspace_from_the_dropdown_in_extraction_homepage(String workSpace)
			throws InterruptedException {
		navigateIntoRefresh();
		clickbtn(ws.getWorkSpaceDropdownSelectExt());
		String workSpaceToSelect = "//a[text()='" + workSpace + "']";
		// customXpath(workSpaceToSelect);
		clickbtn(customXpath(workSpaceToSelect));
		Thread.sleep(3000);
	}

	@When("User clicks back to container workspace")
	public void user_clicks_back_to_container_workspace() {
		clickbtn(ws.getBackToContainerWorkspace());
	}

	@When("User switches to tab")
	public void user_switches_to_tab() {
		siwtchIntoWindow();
	}

	@When("User selects the file {string}")
	public void user_selects_the_file(String fileName) {
		String fileUploaded = "(//span[text()='" + fileName + "']/preceding::input[@type='checkbox'])[last()]";
		clickbtn(customXpath(fileUploaded));
	}

	@When("User locks the file and validates it {string}")
	public void user_locks_the_file_and_validates_it(String fileName) {
//		String fileUploaded = "(//span[text()='" + fileName + "']/preceding::input[@type='checkbox'])[last()]";
//		clickbtn(customXpath(fileUploaded));

		clickbtn(ws.getLockFile());
		String fileLocked = "(//span[text()='" + fileName + "']/preceding::i[@title='User assigned!'])[last()]";
		isPresent(customXpath(fileLocked));
	}

	@When("User unlocks the file and validates it {string}")
	public void user_unlocks_the_file_and_validates_it(String fileName) {
//		String fileUploaded = "(//span[text()='" + fileName + "']/preceding::input[@type='checkbox'])[last()]";
//		clickbtn(customXpath(fileUploaded));

		clickbtn(ws.getUnlockFile());
		String fileUnlocked = "(//span[text()='" + fileName + "']/preceding::i[@title='Unassigned!'])[last()]";
		isPresent(customXpath(fileUnlocked));
	}

	@When("User clicks the assigned and extraction")
	public void user_clicks_the_assigned_and_extraction() throws InterruptedException {
		Thread.sleep(2000);
		clickbtn(ws.getAssignedFile());
		clickbtn(ws.getExtractionAssignedFile());
	}

	@When("User clicks the lock as a user who didnt lock the file")
	public void user_clicks_the_lock_as_a_user_who_didnt_lock_the_file() {
		String documentDisabled = "//button[@title='Document(s) is locked by another user']";
		presenceOfElementLocated(5, 1, documentDisabled);
//		Assert.assertFalse("Lock icon disabled", ws.getLockFile().isEnabled());
	}

	@When("User clicks the open icon in the file {string}")
	public void user_clicks_the_open_icon_in_the_file(String fileName) {

		String fileOpenIcon = "//span[text()='" + fileName + "']/following::i[@class='fa fa-file-pdf']";
		clickbtn(customXpath(fileOpenIcon));
	}

	@When("User clicks the pause extraction")
	public void user_clicks_the_pause_extraction() throws InterruptedException {
//		String parenttab = driver.getWindowHandle();
//		System.out.println("Parent Window : " + parenttab);
		user_switches_to_tab();
		Thread.sleep(20000);
		clickbtn(ws.getPauseExtraction());
//		driver.close();
//		driver.switchTo().window(parenttab);
	}

	@When("user validates the file lock after extraction {string}")
	public void user_validates_the_file_lock_after_extraction(String fileName) {
		navigateIntoRefresh();
		String fileLocked = "(//span[text()='" + fileName + "']/preceding::i[@title='User assigned!'])";
		isPresent(customXpath(fileLocked));
	}

	@When("User waits for two minutes")
	public void user_waits_for_two_minutes() throws InterruptedException {
		Thread.sleep(60000);

	}

	@When("User clicks the Add new record in the extracting page")
	public void user_clicks_the_Add_new_record_in_the_extracting_page() throws InterruptedException {
		user_switches_to_tab();
		clickbtn(ws.getAddNewRecord());
		Thread.sleep(2000);
	}

	@When("User selects the text and selects the field to put text {string} {string}")
	public void user_selects_the_text_and_selects_the_field_to_put_text(String text, String field)
			throws InterruptedException {
		String textSelect = "//span[contains(text(),'" + text + "')]";
		clickbtn(customXpath(textSelect));
		String fieldSelect = "//th[contains(text(),'Name')]/following::span[text()='" + field + "']";
		clickbtn(customXpath(fieldSelect));
		Thread.sleep(3000);
	}

	@When("User clicks the highlight all value in a page marker icon")
	public void user_clicks_the_highlight_all_value_in_a_page_marker_icon() {

		clickbtn(ws.getHighlightMarker());
	}

	@When("User verifies the highlighted text {string}")
	public void user_verifies_the_highlighted_text(String text) throws InterruptedException {
		String highlightedText = "//span[@class='textNodes selected'][contains(text(),'" + text + "')]";
		Thread.sleep(2000);
		// driver.findElement(By.xpath(highlightedText)).isSelected();
		Assert.assertTrue("Text Highlighted: ", customXpath(highlightedText).isEnabled());
	}

	@When("User clicks the refresh in the extraction page")
	public void user_clicks_the_refresh_in_the_extraction_page() {
		clickbtn(ws.getRefreshIcon());
	}

	@When("User verifies the hihlighted text in the field panel {string} {string}")
	public void user_verifies_the_hihlighted_text_in_the_field_panel(String text, String field) {

		String highlightTextFieldPanel = "//th[contains(text(),'Name')]/following::span[text()='" + field
				+ "']/following::td//div//span[contains(text(),'" + text + "')]";
		String textHighlighted = getTextCall(customXpath(highlightTextFieldPanel));
//		Assert.assertEquals(text, textHighlighted);
		Assert.assertTrue(textHighlighted.contains(text));
	}

	@When("User gets the current window")
	public void user_gets_the_current_window() {
		parentTab = driver.getWindowHandle();
		System.out.println("Parent Window : " + parentTab);
	}

	@When("User closes the current window")
	public void user_closes_the_current_window() {
		driver.close();
		driver.switchTo().window(parentTab);
	}

	@When("User adds more text to the selected field")
	public void user_adds_more_text_to_the_selected_field(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {

		List<String> l = dataTable.asList();
		int listSize = l.size();
		System.out.println("List size : " + listSize);
//		Thread.sleep(2000);
//		for (int i = 0; i < listSize; i++) {
//		}
		String textSelect = "//span[contains(text(),'" + l.get(0) + "')]";
		String fieldSelect = "//th[contains(text(),'Name')]/following::span[text()='" + l.get(1) + "']";
		clickbtn(customXpath(textSelect));
		Thread.sleep(2000);
		dropDwoncall(customXpath(fieldSelect));
		String plusTextField = "//span[text()='" + l.get(1) + "']/following::div[@class='field_name_plus']";
		System.out.println(driver.findElement(By.xpath(plusTextField)).getSize());
		javaScriptExecutorClickcall(customXpath(plusTextField));
//		clickbtn(customXpath(plusTextField));

		clickbtn(customXpath(fieldSelect));
		Thread.sleep(3000);

	}

	@When("User clicks the image mode in the extracting page")
	public void user_clicks_the_image_mode_in_the_extracting_page() {
		elementToBeClickable(5, 1, ws.getImageSelectionMode(), "");
		clickbtn(ws.getImageSelectionMode());
	}

	@When("User selects the area for the image")
	public void user_selects_the_area_for_the_image() {

		driver.findElement(By.xpath("//span[contains(text(),'Simple')]")).click();
		System.out.println(driver.findElement(By.xpath("//span[contains(text(),'Simple')]")).getSize());
		Actions a = new Actions(driver);
		dropDwoncall(driver.findElement(By.xpath("//span[contains(text(),'File')]")));
		// a.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'File')]"));
		System.out.println(driver.findElement(By.xpath("//span[contains(text(),'File')]")).getSize());
		driver.findElement(By.xpath("//span[contains(text(),'File')]")).click();
	}

	@When("User selects the field for the image {string}")
	public void user_selects_the_field_for_the_image(String field) throws InterruptedException {
		String fieldSelect = "//th[contains(text(),'Name')]/following::span[text()='" + field + "']";
		clickbtn(customXpath(fieldSelect));
		Thread.sleep(2000);
	}

	@When("User clicks the image on the field panel and validates the image area {string}")
	public void user_clicks_the_image_on_the_field_panel_and_validates_the_image_area(String field) {
		String fieldSelect = "//th[contains(text(),'Name')]/following::span[text()='" + field
				+ "']/following::span//i[@class='fas fa-image']";
		clickbtn(customXpath(fieldSelect));
		elementIsEnabled(ws.getRectangleImageArea());
	}

	@When("User clicks the back button")
	public void user_clicks_the_back_button() throws InterruptedException {
		clickbtn(ws.getBackButton());
		Thread.sleep(2000);
	}

	@When("user selects the field for extraction")
	public void user_selects_the_field_for_extraction() throws InterruptedException {

		System.out.println("Total Checkboxes : " + ws.getCheckFieldCount());
		for (int i = 1; i < ws.getCheckFieldCount(); i++) {
			String checkField = "(//div[@class='captured_value_section']/../../../..//td//input)[" + i + "]";
			System.out.println("CHECK FIELD : " + checkField);
			clickbtn(customXpath(checkField));
			Thread.sleep(2000);
		}

		System.out.println("Total Records added : " + ws.getFindSimilarRecordsCount());

		for (int i = 1; i < ws.getFindSimilarRecordsCount(); i++) {
			int j = 2;
			int c = i * j;
			String fieldClick = "(//div[@class='captured_value_section']//span[@title])[" + c + "]";
			System.out.println("Field CLick : " + fieldClick);
			clickbtn(customXpath(fieldClick));

		}
	}

	@When("User selects all the fileds for Field Scanning")
	public void user_selects_all_the_fileds_for_Field_Scanning() {

		clickbtn(ws.getCheckBoxCheckField());
		System.out.println("Total Records added : " + ws.getFindSimilarRecordsCount());

		for (int i = 1; i < ws.getFindSimilarRecordsCount(); i++) {
			int j = 2;
			int c = i * j;
			String fieldClick = "(//div[@class='captured_value_section']//span[@title])[" + c + "]";
			System.out.println("Field CLick : " + fieldClick);
			clickbtn(customXpath(fieldClick));

		}

	}

	@When("User clicks the Add to context marker for the text {string}")
	public void user_clicks_the_Add_to_context_marker_for_the_text(String text) throws InterruptedException {
		String textToContextMarket = "//div[@class='part_selection_and_btn']//span[contains(text(),'" + text
				+ "')]/following::span[@title='Add as context marker!']";
		Thread.sleep(2000);
		javaScriptExecutorClickcall(customXpath(textToContextMarket));
//	    dropDwoncall(customXpath(textToContextMarket));
//	    clickbtn(customXpath(textToContextMarket));
		Thread.sleep(3000);
		String contextMarket = "//div[@class='part_selection_and_btn']//span[contains(text(),'" + text
				+ "')]/following::span[@title='Context marker!']";
		elementIsEnabled(customXpath(contextMarket));
	}

	@When("User uploads the multiple files")
	public void user_uploads_the_multiple_files(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException, AWTException {
		List<String> l = dataTable.asList();
		int listSize = l.size();
		System.out.println("List size : " + listSize);

		String currentDirectory = System.getProperty("user.dir");
		System.out.println("The current working directory is " + currentDirectory);
		for (int i = 0; i < listSize; i++) {
			clickbtn(ws.getUploadExtractPage());
			// C:\Users\TEST\Downloads\NeoXtractzip\NeoXtract\src\test\resources\Files\Untitled_spreadsheet.pdf
			String filePath = currentDirectory + "\\src\\test\\resources\\Files\\" + l.get(i);
			System.out.println("File Path : " + filePath);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection str = new StringSelection(filePath);
			clipboard.setContents(str, null);
			Thread.sleep(2000);
			String upload_xpath = "//div[@class='dropzone-custom-content dz-message']//i[@class='file_upload_icon']";
//			WebElement element = driver.findElement(By.xpath(upload_xpath));
//			element.click();
			clickbtn(customXpath(upload_xpath));
			Thread.sleep(3000);
			robotPASTECall();
			Thread.sleep(1000);
			robotENTERCall();
			Thread.sleep(3000);
			clickbtn(ws.getUploadAndClose());
			Thread.sleep(5000);
		}
	}

	@When("User gets the current document page")
	public void user_gets_the_current_document_page() throws InterruptedException {

		String value = getAttributcall(ws.getDocumentPageNo(), "type");
		System.out.println("VALUE : " + value);
	}

	@When("User clicks the shortcut key to go to next page")
	public void user_clicks_the_shortcut_key_to_go_to_next_page()
			throws AWTException, IOException, InterruptedException {
		visibilityOf(10, 1, ws.getDocumentPageNo(), "");
		robotCONTROLRIGHTCall();
		Thread.sleep(3000);
		takeScreenshotFullCall("pageNext");
	}

	@When("User clicks the Documents on the left panel")
	public void user_clicks_the_Documents_on_the_left_panel() throws InterruptedException {
		clickbtn(ws.getDocumentLeftPanel());
		Thread.sleep(2000);
	}

	@When("User clicks the shortcut key to go to previous page")
	public void user_clicks_the_shortcut_key_to_go_to_previous_page() throws Exception {
		visibilityOf(10, 1, ws.getDocumentPageNo(), "");
		robotCONTROLLEFTCall();
		Thread.sleep(3000);
		takeScreenshotFullCall("pagePrevious");
	}

	@When("User clicks the up shortcut key to go to next page")
	public void user_clicks_the_up_shortcut_key_to_go_to_next_page()
			throws AWTException, InterruptedException, IOException {
		visibilityOf(10, 1, ws.getDocumentPageNo(), "");
		clickbtn(ws.getDocumentPageNo());
		robotUPCall();
		Thread.sleep(3000);
		takeScreenshotFullCall("pageNextUp");
	}

	@When("User clicks the down shortcut key to go to previos page")
	public void user_clicks_the_down_shortcut_key_to_go_to_previos_page()
			throws AWTException, InterruptedException, IOException {
		visibilityOf(10, 1, ws.getDocumentPageNo(), "");
		if (ws.getDocumentPageNo().isEnabled()) {
			System.out.println("InSIDE IF ");
			clickbtn(ws.getDocumentPageNo());
			robotDOWNCall();
			Thread.sleep(3000);
			takeScreenshotFullCall("pagePreviousDown");
		} else {
			System.out.println("InSIDE ELSE ");
			robotDOWNCall();
			Thread.sleep(3000);
			takeScreenshotFullCall("pagePreviousDown");
		}

	}

	@When("User clicks the shortcut key to Add new field in extraction page")
	public void user_clicks_the_shortcut_key_to_Add_new_field_in_extraction_page()
			throws AWTException, InterruptedException {
		user_switches_to_tab();
		visibilityOf(10, 1, ws.getAddNewRecord(), "");
		robotALTNCall();
		Thread.sleep(3000);
		elementIsEnabled(ws.getAddNewExtracting());
	}

	@When("User navigates to the field using shortcut keys in extraction page {string} {string}")
	public void user_navigates_to_the_field_using_shortcut_keys_in_extraction_page(String field1, String field2)
			throws InterruptedException, AWTException {

		String fieldSelect = "//span[text()='" + field1 + "']";
		dropDwoncall(customXpath(fieldSelect));
		javaScriptExecutorClickcall(customXpath(fieldSelect));

		Thread.sleep(1000);
		robotCONTROLDOWNCall();
		Thread.sleep(1000);
		String fieldNavigatedDown = "(//tr[@class='for_action selected']//span[text()='" + field2 + "'])[1]";
		elementIsEnabled(customXpath(fieldNavigatedDown));

		robotCONTROLUPCall();
		Thread.sleep(1000);
		String fieldNavigatedUp = "(//tr[@class='for_action selected']//span[text()='" + field1 + "'])[1]";
		elementIsEnabled(customXpath(fieldNavigatedUp));
	}

	@When("User add new extracted field for extraction")
	public void user_add_new_extracted_field_for_extraction() throws Exception {
		clickbtn(ws.getAddNewExtracting());
		Thread.sleep(2000);
	}

	@When("User navigates to the document record fields")
	public void user_navigates_to_the_document_record_fields() throws Exception {

		String documentRecordRows = "//tr[contains(@class,'label-records')]";
		int documentRecordCount = driver.findElements(By.xpath(documentRecordRows)).size();
		dropDwoncall(customXpath(documentRecordRows));
		for (int i = 1; i <= documentRecordCount; i++) {
			Thread.sleep(1000);
			robotCONTROLDOWNCall();
			Thread.sleep(1000);
			String selectedDocument = "(//tr[contains(@class,'label-records record-row record is_highlight')])";
			elementIsEnabled(customXpath(selectedDocument));
		}

		for (int i = 1; i <= documentRecordCount; i++) {
			Thread.sleep(1000);
			robotCONTROLUPCall();
			Thread.sleep(1000);
			String selectedDocument = "(//tr[contains(@class,'label-records record-row record is_highlight')])";
			elementIsEnabled(customXpath(selectedDocument));
		}
	}

	@When("User uses the shortcut key to go to field view of the selected record")
	public void user_uses_the_shortcut_key_to_go_to_field_view_of_the_selected_record() throws Exception {
		String documentRecordRows = "//tr[contains(@class,'label-records')]";
		int documentRecordCount = driver.findElements(By.xpath(documentRecordRows)).size();

		// for (int i = 1; i <= documentRecordCount; i++) {
		Thread.sleep(1000);
		// robotCONTROLDOWNCall();
		// Thread.sleep(1000);
		String documentSelected = "//tr[contains(@class,'label-records')][" + documentRecordCount + "]";
		clickbtn(customXpath(documentSelected));
//		String selectedDocument = "(//tr[contains(@class,'label-records record-row record is_highlight')])";
//		elementIsEnabled(customXpath(selectedDocument));
		// }
		robotCONTROLSPACECall();
		Thread.sleep(2000);
	}

	@When("user uses the shortcut key to go back to document records")
	public void user_uses_the_shortcut_key_to_go_back_to_document_records() throws AWTException, InterruptedException {
		robotCONTROLBACKSPACECall();
		Thread.sleep(2000);
		String documentRecordRows = "//tr[contains(@class,'label-records')]";
		visibilityOf(10, 1, customXpath(documentRecordRows), "");
	}

	
	@When("User uses shortcut key to submit extraction")
	public void user_uses_shortcut_key_to_submit_extraction() throws Exception {
	  
		robotCONTROLMCall();
		Thread.sleep(2000);
		alertAcceptCall();
	}
}
