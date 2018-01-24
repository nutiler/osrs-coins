import org.osbot.rs07.api.Bank;
import org.osbot.rs07.api.model.Item;
import org.osbot.rs07.script.ScriptManifest;

import java.awt.*;
import java.io.Console;
import java.util.stream.Stream;

// Contact: JOSH@STORMHEART.NET
// Script: AIO Money Making
// Requirements: Membership, (100,000) Coins, it'll figure the rest out.
// Description: This bot is used to mimic a player trying to earn 
//              coins through methods that require no skills.

@ScriptManifest(author = "Nutiler", info = ":)", name = "Money Bot", version = 0, logo = "")
public class main extends org.osbot.rs07.script.Script {

	// Ability to decide what task to do.
	public boolean basketFilling = false;
	public boolean hideTanning = false;
	public boolean itemCrushing = false;

	// Baskets baskets = new Baskets();

	public final String cookingApple = "Cooking apple";

	public void buyGE(String type, int id, int price, int amount) throws InterruptedException {
		npcs.closest("Grand Exchange Clerk").interact("Exchange");
		main.sleep(main.random(5000, 7000));
		getGrandExchange().buyItem(id, type, price, amount);
		main.sleep(main.random(5000, 7000));
		grandExchange.confirm();
	}

	@Override
	public int onLoop() throws InterruptedException {

		// basketFilling = true;
		itemCrushing = true;

		// logic for random fruits
		if (basketFilling) {
			fill(cookingApple);
		}

		if (itemCrushing) {
			crush("Unicorn horn", 1);
		}

		return 1000;

	}

	public void crush(String type, int amount) throws InterruptedException {

		bank.open();
		main.sleep(main.random(200, 300));

		if (bank.isOpen()) {
			bank.depositAll();
			main.sleep(main.random(100, 200));

			bank.withdraw("Pestle and mortar", 1);

			// TODO
			
		}
	}

	// Contact: JOSH@STORMHEART.NET
	// Script: AIO Money Making
	// Requirements: Membership, (100,000) Coins, it'll figure the rest out.
	// Description: This bot is used to mimic a player trying to earn
	// coins through methods that require no skills.

	public void fill(String type) throws InterruptedException {

		// Check if bank is open and inventory is empty.
		if (bank.isOpen()) {
			if (inventory.getEmptySlotCount() != 28) {

				bank.depositAll();
				main.sleep(main.random(100, 200));

			}

			// Withdraw the correct supplies if it has enough.
			if (bank.getAmount("Basket") >= 4 && bank.getAmount(type) >= 20) {

				bank.withdraw("Basket", 4);
				main.sleep(main.random(100, 200));
				bank.withdrawAll(type);
				main.sleep(main.random(100, 200));
				bank.close();
				log("Withdrawing Supplies.");

			} else {
				if (bank.getAmount("Basket") >= 4) {
					log("Out of Baskets.");
				} else {
					log("Out of " + type + "s.");
				}
				basketFilling = false;
			}
		}

		// Check if the inventory is setup correctly.
		if (getInventory().contains("Basket") && (getInventory().getAmount(type) >= 5) && !bank.isOpen()) {

			// Fill first 4 rows of baskets.
			mouse.click(main.random(573, 595), main.random(223, 233), false);
			main.sleep(main.random(1, 10));
			mouse.click(main.random(603, 636), main.random(228, 238), false);
			main.sleep(main.random(1, 10));
			mouse.click(main.random(645, 679), main.random(225, 238), false);
			main.sleep(main.random(1, 10));
			mouse.click(main.random(690, 720), main.random(221, 232), false);
			main.sleep(main.random(1000, 1000));
			if (getInventory().contains("Basket") && (getInventory().getAmount(type) >= 5) && !bank.isOpen()) {
				getInventory().interact("Fill", "Basket");
				log("Mistake fixed.");
			}
			log("Baskets Filled.");
		}

		bank.open();

	}

}