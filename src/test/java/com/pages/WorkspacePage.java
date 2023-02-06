package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.GlobalLibrary;

public class WorkspacePage extends GlobalLibrary {
	public WorkspacePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@id='profile_picture']")
	private WebElement icon;

	@FindBy(xpath = "//li[contains(@class,'dropdown nav_item')]//a[contains(text(),'Billing')]")
	private WebElement billingOption;

	@FindBy(xpath = "//a[normalize-space(text())='Subscription']")
	private WebElement dropdownBillingOptionSubscription;

	@FindBy(xpath = "//a[contains(text(),'Admin Panel')]")
	private WebElement adminpanel;

	@FindBy(xpath = "//a[contains(text(),'Workspace Setup')]")
	private WebElement workspaceSetupHeader;

	@FindBy(xpath = "//a[contains(text(),'Add Workspace')]")
	private WebElement addworkspaceButton;

	@FindBy(xpath = "//button[@class='btn uq-btn-add back_button']")
	private WebElement buttonleftright;

//"//div[text()='Individual*']/..//parent::div[@class='row']//following-sibling::div[@class='footer_section']//button[text()='Buy']"
	@FindBy(xpath = "//div[text()='Individual*']/following::button[text()='Buy']")
	private WebElement individualBuyButton;

	@FindBy(xpath = "//input[@placeholder='Card number']")
	private WebElement cardnumber;

	@FindBy(xpath = "//input[@name='exp-date']")
	private WebElement expdate;

	@FindBy(xpath = "//input[@name='cvc']")
	private WebElement cvc;

	@FindBy(xpath = "//input[@name='postal']")
	private WebElement zip;

	@FindBy(xpath = "//button[@id='card-button']")
	private WebElement placeOrder;

	@FindBy(xpath = "//div[@class='workspace_item']")
	private List<WebElement> items;

	@FindBy(xpath = "//a[contains(text(),'Change Password')]")
	private WebElement passwordReset;

	@FindBy(xpath = "//input[@placeholder='Existing password']")
	private WebElement existPassword;

	@FindBy(xpath = "//input[@placeholder='New password']")
	private WebElement newPassword;

	@FindBy(xpath = "//input[@placeholder='Confirm new password']")
	private WebElement confirmPassword;

	@FindBy(xpath = "//button[@type='button']//b[text()='Submit']")
	private WebElement passwordResetSubmit;

	@FindBy(xpath = "//a[contains(text(),'Sign Out')]")
	private WebElement signOut;

	@FindBy(xpath = "//div[@class=\"workspace_subscriptions\"]//button[@class='btn uq-toggle-btn refresh_btn']/following-sibling::label[@class='header_text']")
	private WebElement billingSubscriptionWorkspace;

	@FindBy(xpath = "//div[@class=\"workspace_subscriptions\"]//button[@class='btn uq-toggle-btn refresh_btn']/following-sibling::label[@class='header_text']")
	private List<WebElement> billingSubscriptionWorkspaces;

	@FindBy(xpath = "//a[contains(text(),'Billing')]/following::a[contains(text(),'Add Workspace')]")
	private WebElement billingSubscriptionAddWorkspace;

	@FindBy(xpath = "//span[contains(text(),'Team+')]")
	private WebElement teamPlus;

	@FindBy(xpath = "//span[text()='Team']")
	private WebElement team;

	@FindBy(xpath = "(//div[@class='ws_action_section']//i[contains(@class,'fas fa-edit')])[last()]")
	private WebElement teamPlusEdit;

	@FindBy(xpath = "//input[@placeholder='Cluster Name']")
	private WebElement clusterName;

	@FindBy(xpath = "//button[contains(text(),'Add')]")
	private WebElement clusterNameAdd;

	@FindBy(xpath = "//button[contains(text(),'Add')]")
	private List<WebElement> clusterNameAddList;

	@FindBy(xpath = "//span[@title='Click Here To Remove Workspace']")
	private WebElement teamPlusclusterDelete;

	@FindBy(xpath = "//span[@title='Click Here To Remove Workspace']")
	private List<WebElement> teamPlusclusterDeleteAll;

	@FindBy(xpath = "//td[@class='first_col'][text()]")
	private List<WebElement> clusterNameAll;

	@FindBy(xpath = "//h4[contains(text(),'Extraction Fields')]/following::button[contains(text(),'Add Field')]")
	private WebElement extractionAddField;

	@FindBy(xpath = "//h4[contains(text(),'Extraction Fields')]/following::input[@id='field_name']")
	private WebElement extractionFieldName;

	@FindBy(xpath = "//h4[contains(text(),'Extraction Fields')]/following::input[@id='field_description']")
	private WebElement extractionFieldDescription;

	@FindBy(xpath = "//h4[contains(text(),'Extraction Fields')]/following::button[@type='submit'][contains(text(),'Save')]")
	private WebElement extractionFieldSave;

	@FindBy(xpath = "//h4[contains(text(),'Extraction Fields')]//span[text()='( 15/15 )']")
	private WebElement extractionFieldFull;

	@FindBy(xpath = "//select[@class='form-control uq-ip-bt-line']")
	private WebElement userAssignmentDropDown;

	@FindBy(xpath = "//button[contains(text(),'Assign')]")
	private WebElement assignUserAssignment;

	@FindBy(xpath = "//span[@title='Click Here To Remove User']")
	private WebElement removeUserAssignment;

	@FindBy(xpath = "//span[@title='Click Here To Remove User']")
	private List<WebElement> removeUserAssignmentAll;

	@FindBy(xpath = "//h4[contains(text(),'User Assignment')]/following::td//label")
	private List<WebElement> allUsersAssigned;

	@FindBy(xpath = "(//div[@class='workspace_item'])[last()]//i[contains(@class,'fas fa-edit')]")
	private WebElement lastWorkSpaceCreated;

	@FindBy(xpath = "//a[contains(text(),'Edit')]")
	private WebElement workspaceNameEdit;

	@FindBy(xpath = "//input[@id='workspace_edit_name']")
	private WebElement workspaceNameEditText;
	
	@FindBy(xpath = "//i[@title='Update']")
	private WebElement workspaceNameUpdate;
      
	@FindBy(xpath = "//div[contains(text(),'Activate')]")
	private WebElement workspaceActivateIcon;
    
	@FindBy(xpath = "(//label[contains(text(),'Agree')]/preceding::input[@type='checkbox'])[last()]")
	private WebElement agreeCheckBox;
	

	@FindBy(xpath = "//button[contains(text(),'Activate')]")
	private WebElement activateWorkspace;
	
	@FindBy(xpath = "//label[text()='ACTIVE']")
	private WebElement activeStatusWorkspace;
	
	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	private WebElement buttonOk;
	
	@FindBy(xpath = "//div[text()='Team+*']/following::button[text()='Buy']")
	private WebElement teamPlusBuy;
	
	@FindBy(xpath = "//a[@class='delete action_btn not-active']//i[@title='Delete']")
	private WebElement fieldDeleteIcon;
	
	@FindBy(xpath = "//a[@class='action_btn not-active']//i[@title='Edit']")
	private WebElement fieldEditIcon;
	
	@FindBy(xpath = "//button[contains(text(),'Add Template')]")
	private WebElement addTemplate;

	@FindBy(xpath = "//input[@placeholder='Name'][@id='export_name']")
	private WebElement addTemplateName;

	@FindBy(xpath = "//input[@placeholder='Description'][@id='ex_description']")
	private WebElement addTemplateDescription;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement templateSave;
	
	@FindBy(xpath = "//a[@class='action_btn allow_click']//i[@title='Build Template']")
	private WebElement buildTemplate;

	@FindBy(xpath = "//a[@class='action_btn']//i[@title='Edit']")
	private WebElement templateFieldEdit;
	
	
	@FindBy(xpath = "//p[@class='add_icon']")
	private WebElement addSegmentIcon;

	@FindBy(xpath = "//select[@id='processor_list']")
	private WebElement transformationDropDown;

	@FindBy(xpath = "//select[@id='segment_field_list']")
	private WebElement segmentListDropDown;

	@FindBy(xpath = "//select[@id='segment_parameter']")
	private WebElement segmenParametDropDown;

	@FindBy(xpath = "//button[contains(text(),'Create')][@class='btn uq-btn-primary']")
	private WebElement templateBuilderCreate;
	
	@FindBy(xpath = "//input[@id='customText']")
	private WebElement templateCustomText;
	
	@FindBy(xpath = "//a[contains(text(),'User Setup')]")
	private WebElement userSetup;

	@FindBy(xpath = "//a[contains(text(),'Create New User')]")
	private WebElement createNewUser;
	
	@FindBy(xpath = "//input[@id='name']")
	private WebElement userSetupName;
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement userSetupEmail;
	
	@FindBy(xpath = "//input[@id='employee_id']")
	private WebElement userSetupEmployeeId;
	
	@FindBy(xpath = "//label[contains(text(),'INACTIVE')]/preceding::input[@value='INACTIVE']")
	private WebElement inactiveButton;
	
	@FindBy(xpath = "//label[contains(text(),'ACTIVE')]/preceding::input[@value='ACTIVE']")
	private WebElement activeButton;
	
	@FindBy(xpath = "//a[text()='Invoice']")
	private WebElement invoiceBilling;
	
	@FindBy(xpath = "//table//tbody//tr")
	private List<WebElement> invoiceRows;
	
	@FindBy(xpath = "(//button[@class='btn uq-toggle-btn']//i[@class='fas fa-angle-down'])[last()]")
	private WebElement subscriptionLastUserDropDown;
	
	@FindBy(xpath = "(//select[@id='product'])[last()]")
	private WebElement subscriptionProductDropDown;
	
	@FindBy(xpath = "//a[contains(text(),'Update Subscription')]")
	private WebElement subscriptionUpdate;
	
	@FindBy(xpath = "//a[contains(text(),'Confirm Subscription')][@class]")
	private WebElement subscriptionUpdateConfirm;
	
	@FindBy(xpath = "//a[contains(text(),'Go Back')][@class]")
	private WebElement subscriptionGoBack;
	
	@FindBy(xpath = "(//select[@id='interval'])[last()]")
	private WebElement subscriptionCycleDropDown;
	
	@FindBy(xpath = "//li[text()='Subscription Upgraded' or text()='Interval has been updated']")
	private WebElement subscriptionUpgradeMessage;
	
	@FindBy(xpath = "//a[contains(text(),'Cancel')][@class]")
	private WebElement cancelButton;
	
	@FindBy(xpath = "//a[contains(text(),'Operations')]")
	private WebElement operationsHeader;
	
	@FindBy(xpath = "//a[contains(text(),'Documents')]")
	private WebElement documentsOperationsHeader;
	
	@FindBy(xpath = "//a[contains(text(),'Records')]")
	private WebElement recordsOperationsHeader;
	
	@FindBy(xpath = "//button[contains(text(),'Upload')][@class='btn uq-btn-add']")
	private WebElement documentUpload;
	
	@FindBy(xpath = "//button[contains(text(),'Upload and Close')]")
	private WebElement uploadAndClose;
	
	@FindBy(xpath = "//button[@id='dropdownMenuButton']")
	private WebElement workSpaceDropdownSelectExt;
	

	@FindBy(xpath = "//button[@type='button']//i[@class='upload_icon']/following-sibling::span")
	private WebElement uploadExtractPage;
	
	@FindBy(xpath = "//input[@placeholder='Country']")
	private WebElement uploadCountry;
	
	@FindBy(xpath = "//input[@placeholder='Publishing Year']")
	private WebElement uploadPublishYear;	
	
	@FindBy(xpath = "//input[@placeholder='Language']")
	private WebElement uploadLanguage;
	
	@FindBy(xpath = "//input[@placeholder='Document Type']")
	private WebElement uploadDocumentType;
	
	@FindBy(xpath = "//input[@placeholder='Publisher Name']")
	private WebElement uploadPublisherName;
	
	
	@FindBy(xpath = "//a[contains(text(),'Back to Container Workspace')]")
	private WebElement backToContainerWorkspace;
	
	@FindBy(xpath = "//span[text()='Lock']")
	private WebElement lockFile;
	
	@FindBy(xpath = "//span[text()='Unlock']")
	private WebElement unlockFile;
	
	
	@FindBy(xpath = "//span[text()='Assigned']")
	private WebElement assignedFile;
	
	@FindBy(xpath = "//span[text()='Extraction']")
	private WebElement extractionAssignedFile;
	
	@FindBy(xpath = "//button[@title='Document(s) is locked by another user']")
	private WebElement doumentLockDisabled;
	
	@FindBy(xpath = "//button[text()='Submit Extraction']")
	private WebElement submitextraction;
	
	@FindBy(xpath = "//span[@class='add_new_record']")
	private WebElement addNewRecord;
	
	@FindBy(xpath = "//span[@title='highlight all values in a page']")
	private WebElement highlightMarker;
	
	@FindBy(xpath = "//button[@title='Refresh']//i[@class='refresh_icon']")
	private WebElement refreshIcon;
	
	@FindBy(xpath = "//button[@title='Image selection mode']")
	private WebElement imageSelectionMode;
	
	
	@FindBy(xpath = "//div[@class='rectangle_area']")
	private WebElement rectangleImageArea;
	
	@FindBy(xpath = "//span[contains(text(),'Back')]")
	private WebElement backButton;
	
	@FindBy(xpath = "//div[@class='captured_value_section']/../../../..//td//input")
	private List<WebElement> checkField;
	
	@FindBy(xpath = "//div[@class='captured_value_section']//span[@title]")
	private List<WebElement> findSimilarRecords;
	
	@FindBy(xpath = "//i[@class='fas fa-pause']")
	private WebElement pauseExtraction;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement checkBoxCheckField;
	
	@FindBy(xpath = "//input[@type='number']")
	private WebElement documentPageNo;
	
	@FindBy(xpath = "//span[text()='Documents']")
	private WebElement documentLeftPanel;
	
	@FindBy(xpath = "//button[text()='Add New']")
	private WebElement addNewExtracting;
	
	
	
	

	public WebElement getSignOut() {
		return signOut;
	}

	public List<WebElement> getItems() {
		return items;
	}

	public WebElement getPasswordReset() {
		return passwordReset;
	}

	public List<WebElement> getItem() {
		return items;
	}

	public WebElement getIcon() {
		return icon;
	}

	public WebElement getAdminpanel() {
		return adminpanel;
	}

	public WebElement getWorkspaceSetupHeader() {
		return workspaceSetupHeader;
	}

	public WebElement getAddworkspaceButton() {
		return addworkspaceButton;
	}

	public WebElement getButtonleftright() {
		return buttonleftright;
	}

	public WebElement getIndividualBuyButton() {
		return individualBuyButton;
	}


	public WebElement getCardnumber() {
		return cardnumber;
	}

	public WebElement getExpdate() {
		return expdate;
	}

	public WebElement getCvc() {
		return cvc;
	}

	public WebElement getZip() {
		return zip;
	}

	public WebElement getPlaceOrder() {
		return placeOrder;
	}

	public int togetWorkspaceItemCount() {
		return getItem().size();
	}

	public WebElement getBillingHeaderOption() {
		return billingOption;
	}

	public WebElement getBillingOption() {
		return billingOption;
	}

	public WebElement getDropdownBillingOptionSubscription() {
		return dropdownBillingOptionSubscription;
	}

	public WebElement getExistPassword() {
		return existPassword;
	}

	public WebElement getNewPassword() {
		return newPassword;
	}

	public WebElement getConfirmPassword() {
		return confirmPassword;
	}

	public WebElement getPasswordResetSubmit() {
		return passwordResetSubmit;
	}

	public WebElement getBillingSubscriptionWorkspace() {
		return billingSubscriptionWorkspace;
	}

	public List<WebElement> getBillingSubscriptionWorkspaces() {
		return billingSubscriptionWorkspaces;
	}

	public int getBillingSubscriptionWorkspacesItemCount() {
		return getBillingSubscriptionWorkspaces().size();
	}

	public WebElement getBillingSubscriptionAddWorkspace() {
		return billingSubscriptionAddWorkspace;
	}

	public WebElement getTeamPlus() {
		return teamPlus;
	}

	public WebElement getTeamPlusEdit() {
		return teamPlusEdit;
	}

	public WebElement getClusterName() {
		return clusterName;
	}

	public WebElement getClusterNameAdd() {
		return clusterNameAdd;
	}

	public WebElement getTeamPlusclusterDelete() {
		return teamPlusclusterDelete;
	}

	public List<WebElement> getTeamPlusclusterDeleteAll() {
		return teamPlusclusterDeleteAll;
	}

	public int getTeamPlusclusterDeleteAllCount() {
		return getTeamPlusclusterDeleteAll().size();
	}

	public List<WebElement> getClusterNameAddList() {
		return clusterNameAddList;
	}

	public int getClusterNameAddListCount() {
		return getClusterNameAddList().size();
	}

	public List<WebElement> getClusterNameAll() {
		return clusterNameAll;
	}

	public int getClusterNameAllCount() {
		return getClusterNameAll().size();
	}

	public WebElement getExtractionFieldName() {
		return extractionFieldName;
	}

	public WebElement getExtractionFieldDescription() {
		return extractionFieldDescription;
	}

	public WebElement getExtractionAddField() {
		return extractionAddField;
	}

	public WebElement getExtractionFieldSave() {
		return extractionFieldSave;
	}

	public WebElement getExtractionFieldFull() {
		return extractionFieldFull;
	}

	public WebElement getTeam() {
		return team;
	}

	public WebElement getUserAssignmentDropDown() {
		return userAssignmentDropDown;
	}

	public WebElement getAssignUserAssignment() {
		return assignUserAssignment;
	}

	public WebElement getRemoveUserAssignment() {
		return removeUserAssignment;
	}

	public List<WebElement> getRemoveUserAssignmentAll() {
		return removeUserAssignmentAll;
	}

	public int getRemoveUserAssignmentAllCount() {
		return getRemoveUserAssignmentAll().size();
	}

	public List<WebElement> getAllUsersAssigned() {
		return allUsersAssigned;
	}

	public int getAllUsersAssignedCount() {
		return getAllUsersAssigned().size();
	}

	public WebElement getLastWorkSpaceCreated() {
		return lastWorkSpaceCreated;
	}
	
	public WebElement getWorkspaceNameEdit() {
		return workspaceNameEdit;
	}
	
	public WebElement getWorkspaceNameEditText() {
		return workspaceNameEditText;
	}

	public WebElement getWorkspaceNameUpdate() {
		return workspaceNameUpdate;
	}
	
	public WebElement getWorkspaceActivateIcon() {
		return workspaceActivateIcon;
	}

	public WebElement getAgreeCheckBox() {
		return agreeCheckBox;
	}

	public WebElement getActivateWorkspace() {
		return activateWorkspace;
	}

	public WebElement getActiveStatusWorkspace() {
		return activeStatusWorkspace;
	}

	public WebElement getButtonOk() {
		return buttonOk;
	}

	public WebElement getTeamPlusBuy() {
		return teamPlusBuy;
	}

	public WebElement getFieldDeleteIcon() {
		return fieldDeleteIcon;
	}

	public WebElement getFieldEditIcon() {
		return fieldEditIcon;
	}

	public WebElement getAddTemplate() {
		return addTemplate;
	}

	public WebElement getAddTemplateName() {
		return addTemplateName;
	}

	public WebElement getAddTemplateDescription() {
		return addTemplateDescription;
	}

	public WebElement getTemplateSave() {
		return templateSave;
	}

	public WebElement getBuildTemplate() {
		return buildTemplate;
	}

	public WebElement getTemplateFieldEdit() {
		return templateFieldEdit;
	}

	public WebElement getAddSegmentIcon() {
		return addSegmentIcon;
	}

	public WebElement getTransformationDropDown() {
		return transformationDropDown;
	}

	public WebElement getSegmentListDropDown() {
		return segmentListDropDown;
	}

	public WebElement getSegmenParametDropDown() {
		return segmenParametDropDown;
	}

	public WebElement getTemplateBuilderCreate() {
		return templateBuilderCreate;
	}

	public WebElement getTemplateCustomText() {
		return templateCustomText;
	}

	public WebElement getUserSetup() {
		return userSetup;
	}

	public WebElement getCreateNewUser() {
		return createNewUser;
	}

	public WebElement getUserSetupName() {
		return userSetupName;
	}

	public WebElement getUserSetupEmail() {
		return userSetupEmail;
	}

	public WebElement getUserSetupEmployeeId() {
		return userSetupEmployeeId;
	}

	public WebElement getInactiveButton() {
		return inactiveButton;
	}

	public WebElement getActiveButton() {
		return activeButton;
	}
	


	public WebElement getInvoiceBilling() {
		return invoiceBilling;
	}

	public List<WebElement> getInvoiceRows() {
		return invoiceRows;
	}
	
	public int getInvoiceRowsCount() {
		return getInvoiceRows().size();
	}

	public WebElement getSubscriptionLastUserDropDown() {
		return subscriptionLastUserDropDown;
	}

	public WebElement getSubscriptionProductDropDown() {
		return subscriptionProductDropDown;
	}

	public WebElement getSubscriptionUpdate() {
		return subscriptionUpdate;
	}

	public WebElement getSubscriptionUpdateConfirm() {
		return subscriptionUpdateConfirm;
	}

	public WebElement getSubscriptionGoBack() {
		return subscriptionGoBack;
	}

	public WebElement getSubscriptionCycleDropDown() {
		return subscriptionCycleDropDown;
	}

	public WebElement getSubscriptionUpgradeMessage() {
		return subscriptionUpgradeMessage;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	public WebElement getOperationsHeader() {
		return operationsHeader;
	}

	public WebElement getDocumentsOperationsHeader() {
		return documentsOperationsHeader;
	}

	public WebElement getRecordsOperationsHeader() {
		return recordsOperationsHeader;
	}

	public WebElement getDocumentUpload() {
		return documentUpload;
	}

	public WebElement getUploadAndClose() {
		return uploadAndClose;
	}

	public WebElement getWorkSpaceDropdownSelectExt() {
		return workSpaceDropdownSelectExt;
	}

	public WebElement getUploadExtractPage() {
		return uploadExtractPage;
	}

	public WebElement getUploadCountry() {
		return uploadCountry;
	}

	public WebElement getUploadPublishYear() {
		return uploadPublishYear;
	}

	public WebElement getUploadLanguage() {
		return uploadLanguage;
	}

	public WebElement getUploadDocumentType() {
		return uploadDocumentType;
	}

	public WebElement getUploadPublisherName() {
		return uploadPublisherName;
	}

	public WebElement getBackToContainerWorkspace() {
		return backToContainerWorkspace;
	}

	public WebElement getLockFile() {
		return lockFile;
	}

	public WebElement getUnlockFile() {
		return unlockFile;
	}

	public WebElement getAssignedFile() {
		return assignedFile;
	}

	public WebElement getExtractionAssignedFile() {
		return extractionAssignedFile;
	}

	public WebElement getDoumentLockDisabled() {
		return doumentLockDisabled;
	}

	public WebElement getSubmitextraction() {
		return submitextraction;
	}

	public WebElement getAddNewRecord() {
		return addNewRecord;
	}

	public WebElement getHighlightMarker() {
		return highlightMarker;
	}

	public WebElement getRefreshIcon() {
		return refreshIcon;
	}

	public WebElement getImageSelectionMode() {
		return imageSelectionMode;
	}

	public WebElement getRectangleImageArea() {
		return rectangleImageArea;
	}

	public WebElement getBackButton() {
		return backButton;
	}

	public List<WebElement> getCheckField() {
		return checkField;
	}

	public int getCheckFieldCount() {
		return getCheckField().size();
	}

	public List<WebElement> getFindSimilarRecords() {
		return findSimilarRecords;
	}
	
	public int getFindSimilarRecordsCount() {
		return getFindSimilarRecords().size()/2;
	}

	public WebElement getPauseExtraction() {
		return pauseExtraction;
	}

	public WebElement getCheckBoxCheckField() {
		return checkBoxCheckField;
	}

	public WebElement getDocumentPageNo() {
		return documentPageNo;
	}

	public WebElement getDocumentLeftPanel() {
		return documentLeftPanel;
	}

	public WebElement getAddNewExtracting() {
		return addNewExtracting;
	}
	
}
