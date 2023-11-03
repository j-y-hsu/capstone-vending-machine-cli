package com.techelevator;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_OPTION_SALES_REPORT = "Report";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT, MAIN_MENU_OPTION_SALES_REPORT };

	private Menu menu;
	private DisplayMenus displayMenus;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		InventoryManager inventory = new InventoryManager(FileManager.getItems());
		displayMenus = new DisplayMenus(menu, inventory);
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				FormatUtils.displayItems(inventory);
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				displayMenus.purchaseItem();
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Goodbye");
				break;
			} else if (choice.equals(MAIN_MENU_OPTION_SALES_REPORT)) {
				FileManager.salesReport(inventory);
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
