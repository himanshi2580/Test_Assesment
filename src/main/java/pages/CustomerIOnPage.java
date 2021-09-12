package pages;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import commonfunctions.Utils;

public class CustomerIOnPage {
	Utils util = new Utils();

	public CustomerIOnPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//h2[text()='APPLY FOR A NEW CONNECTION ']")
	private WebElement verifyINoPage;

	@FindBy(how = How.ID, using = "name")
	private WebElement input_name;

	@FindBy(how = How.ID, using = "SelectSegment")
	private WebElement select_segment;

	@FindBy(how = How.ID, using = "serviceTypeId")
	private WebElement select_serviceTypeId;

	@FindBy(how = How.ID, using = "mobile")
	private WebElement input_mobile;

	@FindBy(how = How.ID, using = "primaryemail")
	private WebElement input_email;

	@FindBy(how = How.ID, using = "Communicationpincode")
	private WebElement input_pincode;

	@FindBy(how = How.ID, using = "Communicationarea")
	private WebElement input_area;

	@FindBy(how = How.ID, using = "Communicationbuilding")
	private WebElement input_building;

	@FindBy(how = How.ID, using = "Communicationstate")
	private WebElement input_state;

	@FindBy(how = How.ID, using = "Communicationcity")
	private WebElement input_city;

	@FindBy(how = How.XPATH, using = "//span[@class='checkbox-custom rectangular']")
	private WebElement checkbox_addSameAsAbove;

	@FindBy(how = How.ID, using = "Installationpin")
	private WebElement input_installationpin;

	@FindBy(how = How.ID, using = "Installationarea")
	private WebElement input_installationarea;

	@FindBy(how = How.ID, using = "Installationbuilding")
	private WebElement input_installationbuilding;

	@FindBy(how = How.ID, using = "Installationstate")
	private WebElement input_installationstate;

	@FindBy(how = How.ID, using = "Installationcity")
	private WebElement input_installationcity;

	@FindBy(how = How.ID, using = "Orgnaization")
	private WebElement input_orgnaization;

	@FindBy(how = How.ID, using = "alternatemobile")
	private WebElement input_alternatemobile;

	@FindBy(how = How.ID, using = "LandLine")
	private WebElement input_landLine;

	@FindBy(how = How.ID, using = "AssociationName")
	private WebElement input_associationName;

	@FindBy(how = How.ID, using = "AssociationContact")
	private WebElement input_associationContact;

	@FindBy(how = How.ID, using = "AssociationEmail")
	private WebElement input_associationEmail;

	public void launchUrlAndVerify(String browser, String url) {
		util.launchUrl(browser, url);
	}

	public void enterDetails() throws IOException {
		util.verifyElementPresent(verifyINoPage);
		FileInputStream fs = new FileInputStream("Files//WorksheetInQC.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int lastRow = sheet.getLastRowNum();
		for (int i = 1; i < lastRow; i++) {
			Row row = sheet.getRow(i);
			util.enterText(row.getCell(0).getStringCellValue(), input_name);
			util.selectDroppown(row.getCell(1).getStringCellValue(), select_segment);
			util.selectDroppown(row.getCell(2).getStringCellValue(), select_serviceTypeId);
			util.enterText(row.getCell(16).getStringCellValue(), input_mobile);
			util.enterText(row.getCell(15).getStringCellValue(), input_email);
			util.enterText(row.getCell(3).getStringCellValue(), input_pincode);
			util.enterText(row.getCell(4).getStringCellValue(), input_area);
			util.enterText(row.getCell(5).getStringCellValue(), input_building);
			util.enterText(row.getCell(7).getStringCellValue(), input_state);
			util.enterText(row.getCell(6).getStringCellValue(), input_city);
			if (row.getCell(8).getStringCellValue().equalsIgnoreCase("Yes")) {
				util.clickOnWebElement(checkbox_addSameAsAbove);
			}
			if (row.getCell(8).getStringCellValue().equalsIgnoreCase("No")) {
				util.enterText(row.getCell(9).getStringCellValue(), input_installationpin);
				util.enterText(row.getCell(10).getStringCellValue(), input_installationarea);
				util.enterText(row.getCell(11).getStringCellValue(), input_installationbuilding);
				util.enterText(row.getCell(13).getStringCellValue(), input_installationstate);
				util.enterText(row.getCell(12).getStringCellValue(), input_installationcity);
				util.enterText(row.getCell(17).getStringCellValue(), input_orgnaization);
				util.enterText(row.getCell(18).getStringCellValue(), input_alternatemobile);
				util.enterText(row.getCell(19).getStringCellValue(), input_landLine);
			}
			util.enterText(row.getCell(20).getStringCellValue(), input_associationName);
			util.enterText(row.getCell(21).getStringCellValue(), input_associationContact);
			util.enterText(row.getCell(22).getStringCellValue(), input_associationEmail);
		}
		util.closeWindow();
	}
}
