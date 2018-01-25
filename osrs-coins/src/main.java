import org.osbot.OB;
import org.osbot.rs07.api.Bank;
import org.osbot.rs07.api.Store;
import org.osbot.rs07.api.filter.Filter;
import org.osbot.rs07.api.filter.NameFilter;
import org.osbot.rs07.api.filter.PositionFilter;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.api.model.Item;
import org.osbot.rs07.api.model.NPC;
import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.api.ui.EquipmentSlot;
import org.osbot.rs07.input.keyboard.TypeStringEvent;
import org.osbot.rs07.input.mouse.InventorySlotDestination;
import org.osbot.rs07.input.mouse.MainScreenTileDestination;
import org.osbot.rs07.input.mouse.MiniMapTileDestination;
import org.osbot.rs07.input.mouse.MouseDestination;
import org.osbot.rs07.input.mouse.RectangleDestination;
import org.osbot.rs07.script.ScriptManifest;
import org.osbot.rs07.utility.Condition;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// Contact: JOSH@STORMHEART.NET
// Script: AIO Money Making
// Requirements: Membership, (100,000) Coins, it'll figure the rest out.
// Description: This bot is used to mimic a player trying to earn 
//              coins through methods that require no skills.

@ScriptManifest(author = "nutiler", info = "", name = "OSRS-Coins", version = 0.1, logo = "")
public class main extends org.osbot.rs07.script.Script {

	// Ability to decide what task to do.
	public boolean basketFilling = false;
	public boolean hideTanning = false;
	public boolean itemCrushing = false;
	public boolean questDeathPlatue = true;

	public final String cookingApple = "Cooking apple";
	public final String unicornHorn = "Unicorn horn";

	@Override
	public void onStart() {
		log("starting");
	}

	@Override
	public int onLoop() throws InterruptedException {

		// logic for random fruits
		if (questDeathPlatue) {
			doDeathPlatue();
		}

		if (basketFilling) {
			fill(cookingApple);
		}

		if (itemCrushing) {
			crush(unicornHorn, 4);
		}

		return 1000;

	}

	@Override
	public void onExit() {
		log("Exiting script.");
	}

	@Override
	public void onPaint(Graphics2D g) {

	}

	public enum Location {

		// Games necklace teleport.
		BURTHORPE(new Area(2890, 3560, 2906, 3546)),
		// Denulth, start of Death Platue.
		DEATHPLATUE1(new Area(2898, 3533, 2895, 3527)),
		// Burthorpe Castle stairs.
		DEATHPLATUE2(new Area(2896, 3565, 2900, 3561)),
		// Toad and Chicken bar.
		DEATHPLATUE3(new Area(2915, 3537, 2909, 3540)),
		// Upstairs Inn Harolds Room.
		DEATHPLATUE4(new Area(2905, 3543, 2907, 3544)),
		// Upstairs Inn Stair Entrance.
		DEATHPLATUE5(new Area(2914, 3542, 2915, 3543)),
		// Table with colored balls.
		DEATHPLATUE6(new Area(2894, 3565, 2895, 3562)),
		// West Cave Entrance.
		DEATHPLATUE7(new Area(2856, 3573, 2861, 3578)),

		DEATHPLATUE8(new Area(3207, 3220, 3210, 3216));

		// these are the private fields you pre-definded
		private Area area;

		// constructor add what values you need to pre-define
		private Location(Area area) {
			this.area = area;
		}

		// these are simple getter methods.
		// setter method arent allowed because the values are pre-fined so they
		// are basically static.
		public Area getArea() {
			return this.area;
		}
	}

	@SuppressWarnings("unchecked")
	public void doDeathPlatue() throws InterruptedException {
		questDeathPlatue = false;
		// log(Location.BURTHORPE.getArea());

		// buy items
		// 103gp
		// 10 trout
		// 10 bread
		// premade blurbry special
		// 1 iron bar
		// 1 stamina potion

		// unotes items
		// buyGE("trout", 333, 1000, 10);
		// buyGE("bread", 2309, main.random(999,1111), 10);
		// buyGE("premade blur", 2028, 999, 1);
		// buyGE("iron b", 2351, 1111, 1);
		// grandExchange.collect();
		//
		// buyGE("ring of du", 2677, 2000, 1);
		// buyGE("games", 3853, 2000, 1);
		// grandExchange.collect();

		// inventory.interact("Wear", 2552);
		// main.sleep(main.random(100, 200));
		//
		// inventory.interact("Wear", 3853);
		//
		// inventory.interact("Use", 334);
		// main.sleep(main.random(100, 200));
		//
		// if (inventory.isItemSelected()){
		// npcs.closest("Banker").interact("Use");
		// }
		// main.sleep(main.random(1000, 2000));
		// getDialogues().completeDialogueU("Yes");
		// main.sleep(main.random(100, 200));
		//
		// main.sleep(main.random(1000, 2000));
		//
		// inventory.interact("Use", 2310);
		// main.sleep(main.random(100, 200));
		//
		// if (inventory.isItemSelected()){
		// npcs.closest("Banker").interact("Use");
		// }
		// main.sleep(main.random(1000, 2000));
		// getDialogues().completeDialogueU("Yes");
		// main.sleep(main.random(100, 200));

		// getEquipment().openTab();
		// getKeyboard().pressKey((char) KeyEvent.VK_F4);
		// do one of them- antiban
		// getEquipment().interact(2, "Burthrope");

		// getEquipment().interact(EquipmentSlot.AMULET, "Burthorpe");
		// log("looped");

		// if(Location.BURTHORPE.getArea().contains(myPlayer())) {
		// log("Player teleported to BURTHORPE.");
		// getWalking().walk(Location.DEATHPLATUE1.getArea());
		// log("hi");

		// npcs.closest("Denulth").interact("Talk-to");
		// main.sleep(main.random(3000, 4000));
		// if (getDialogues().inDialogue()) {
		// getDialogues().completeDialogueU("Do you have any quests for me?",
		// "No but perhaps I could try and find one?");
		// getWalking().webWalk(Location.DEATHPLATUE2.getArea());
		//
		// RS2Object stairs = objects.closest(4626);
		// if (!stairs.isVisible())
		// camera.toEntity(stairs);
		// stairs.interact("Climb-up");
		// if (npcs.closest(4103) != null)
		// {
		// then upstairs
		// log("where nibba");
		// npcs.closest(4103).interact("Talk-to");
		// main.sleep(main.random(3000, 4000));
		// if (getDialogues().inDialogue()) {
		// getDialogues().completeDialogueU("I'm looking for the guard that was
		// on last night.");
		// }
		// go down stairs
		// RS2Object stairs = objects.closest(4625);
		// stairs.interact("Climb-down");
		// getWalking().webWalk(Location.DEATHPLATUE3.getArea());

		// npcs.closest(4102).interact("Trade");
		// main.sleep(main.random(1000, 2000));
		// getStore().buy(1905,1);
		// RS2Object stairs = objects.closest(15645);
		// stairs.interact("Climb-up");
		//
		// main.sleep(main.random(1000, 2000));
		// getWalking().walk(Location.DEATHPLATUE4.getArea());

		RS2Object door = objects.closest(3747);
		// door.interact("open");
		// main.sleep(main.random(1000, 2000));
		//
		// getDialogues().completeDialogue();

		// npcs.closest(4101).interact("Talk-to");
		// main.sleep(main.random(1000, 2000));

		// getDialogues().completeDialogueU("You're the guard that was on duty
		// last night?");
		// door.interact("open");
		// getWalking().walk(Location.DEATHPLATUE5.getArea());
		// main.sleep(main.random(1000, 2000));
		// RS2Object stairs2 = objects.closest(15648);
		// stairs2.interact("Climb-down");
		// main.sleep(main.random(1000, 2000));
		//
		// getWalking().webWalk(Location.DEATHPLATUE2.getArea());
		// RS2Object stairs4 = objects.closest(4626);
		// if (!stairs4.isVisible())
		// camera.toEntity(stairs4);
		// stairs4.interact("Climb-up");
		// main.sleep(main.random(1000, 2000));

		// npcs.closest(4103).interact("Talk-to");
		// main.sleep(main.random(1000, 2000));

		// getDialogues().completeDialogue();
		// RS2Object stairs = objects.closest(4625);
		// stairs.interact("Climb-down");
		// getWalking().webWalk(Location.DEATHPLATUE3.getArea());

		// RS2Object stairs67 = objects.closest(15645);
		// stairs67.interact("Climb-up");

		// main.sleep(main.random(1000, 2000));
		// getWalking().walk(Location.DEATHPLATUE4.getArea());
		//
		// door.interact("open");
		// main.sleep(main.random(1000, 2000));
		////
		// getDialogues().completeDialogue();
		//
		// npcs.closest(4101).interact("Talk-to");
		// main.sleep(main.random(1000, 2000));
		//
		// getDialogues().completeDialogue();
		// main.sleep(main.random(2000, 3000));
		// getDialogues().completeDialogue("Can I buy you a drink?");
		// main.sleep(main.random(2000, 3000));
		// getDialogues().completeDialogue();
		// npcs.closest(4101).interact("Talk-to");
		// main.sleep(main.random(1000, 2000));
		// getDialogues().completeDialogueU("Would you like to gamble?");
		// main.sleep(main.random(1000, 2000));
		// keyboard.typeString("101");
		// main.sleep(main.random(1000, 2000));
		// getDialogues().completeDialogue();
		// main.sleep(main.random(1000, 2000));

		// gambling solver

		// mouse.click(main.random(228, 287), main.random(245, 254), false);
		// main.sleep(main.random(3000, 4000));
		// mouse.click(main.random(228, 287), main.random(245, 254), false);
		// main.sleep(main.random(3000, 4000));
		// getDialogues().completeDialogue();

		// door.interact("open");
		// getWalking().walk(Location.DEATHPLATUE5.getArea());
		// main.sleep(main.random(1000, 2000));
		// RS2Object stairs2 = objects.closest(15648);
		// stairs2.interact("Climb-down");
		// main.sleep(main.random(1000, 2000));
		//
		// getWalking().webWalk(Location.DEATHPLATUE2.getArea());
		// groundItems.closest(3109).interact("Take");
		// main.sleep(main.random(4000, 6000));
		// groundItems.closest(3110).interact("Take");
		// main.sleep(main.random(2000, 3000));
		// groundItems.closest(3112).interact("Take");
		// main.sleep(main.random(2000, 3000));
		//
		// groundItems.closest(3113).interact("Take");
		// main.sleep(main.random(2000, 3000));
		//
		// groundItems.closest(3111).interact("Take");
		// main.sleep(main.random(2000, 3000));
		// inventory.interact("Read", 3103);
		// main.sleep(main.random(1000, 2000));
		//
		// getDialogues().completeDialogue();
		// main.sleep(main.random(1000, 2000));
		//
		// inventory.interact("Read", 3102);
		// main.sleep(main.random(1000, 2000));
		//
		// mouse.click(main.random(424, 439), main.random(53, 66), false);
		//
		// main.sleep(main.random(1000, 2000));
		//
		// mouse.click(main.random(552, 570), main.random(10, 30), false);

		// List<RS2Object> ballPuzzle = getObjects().filter(
		// obj -> (obj.getId() == 3676 || obj.getId() == 3677) &&
		// Location.DEATHPLATUE6.getArea().contains(obj));
		//
		// RS2Object redBall = ballPuzzle.get(1);
		// RS2Object blueBall = ballPuzzle.get(0);
		// RS2Object yellowBall = ballPuzzle.get(3);
		// RS2Object pinkBall = ballPuzzle.get(4);
		// RS2Object greenBall = ballPuzzle.get(5);
		//
		// inventory.interact("Use", 3109);
		// main.sleep(main.random(2000, 3000));
		// if (inventory.isItemSelected()) {
		// redBall.interact("Use");
		// }
		//
		// inventory.interact("Use", 3110);
		// main.sleep(main.random(2000, 3000));
		// if (inventory.isItemSelected()) {
		// blueBall.interact("Use");
		// }
		//
		// inventory.interact("Use", 3111);
		// main.sleep(main.random(2000, 3000));
		// if (inventory.isItemSelected()) {
		// yellowBall.interact("Use");
		// }
		//
		// inventory.interact("Use", 3112);
		// main.sleep(main.random(2000, 3000));
		// if (inventory.isItemSelected()) {
		// pinkBall.interact("Use");
		// }
		//
		// inventory.interact("Use", 3113);
		// main.sleep(main.random(2000, 3000));
		// if (inventory.isItemSelected()) {
		// greenBall.interact("Use");
		// }

		// walk to cave

		getWalking().webWalk(Location.DEATHPLATUE7.getArea());

		RS2Object cave = objects.closest(3735);
		cave.interact("Enter");

		// }
		//
		// } else {
		// npcs.closest("Denulth").interact("Talk-to");
		// }

		// }

		// Area area = new Area(2892, 3527, 2899, 3536);
		// getWalking().webWalk(area);

		// tele burthrope with items
		// Position[] path = { new Position(2898, 3552, 0), new Position(2896,
		// 3531, 0) };
		// getWalking().walkPath(Arrays.asList(path));

		// MainScreenTileDestination destination = new
		// MainScreenTileDestination(getBot(), area.getRandomPosition());
		// getMouse().click(destination);

		// MiniMapTileDestination destination = new
		// MiniMapTileDestination(getBot(), area.getRandomPosition());

		// talk delnith

	}

	public void buyGE(String type, int id, int price, int amount) throws InterruptedException {
		// get money
		if (!getInventory().contains("Coins") || getInventory().getAmount("coins") <= 20000) {
			main.sleep(main.random(2000, 4000));
			bank.open();
			main.sleep(main.random(2000, 4000));
			bank.withdrawAll("Coins");
			main.sleep(main.random(2000, 4000));
			bank.close();
		}
		if (!getGrandExchange().isOpen()) {
			npcs.closest("Grand Exchange Clerk").interact("Exchange");
		}
		main.sleep(main.random(2000, 4000));
		getGrandExchange().buyItem(id, type, price, amount);
		main.sleep(main.random(2000, 4000));
		grandExchange.confirm();
		main.sleep(main.random(2000, 4000));
	}

	// Remove the items place holder within a bounding box.
	private void placeHolderRemover(int x1, int x2, int y1, int y2) throws InterruptedException {
		int x = main.random(x1, y1);
		int y = main.random(x2, y2);

		mouse.click(x, y, false);
		main.sleep(main.random(1000, 2000));

		x = x + main.random(-80, 75);
		y = y + main.random(20, 30);

		mouse.click(x, y, false);
		main.sleep(main.random(1000, 2000));
	}

	// Fills the bank with placeholder items.
	private void fillBank() throws InterruptedException {
		mouse.click(main.random(470, 490), main.random(50, 65), false);
		main.sleep(main.random(200, 300));
		mouse.click(main.random(210, 305), main.random(283, 312), false);
		main.sleep(main.random(1000, 2000));
		mouse.click(main.random(470, 490), main.random(50, 65), false);
		main.sleep(main.random(200, 300));
	}

	// Move the item to a select inventory location. Credit: Th3
	public void moveInvItem(int from, int to) {
		if (from < 0)
			return;
		Rectangle toRec = InventorySlotDestination.getSlot(to);
		mouse.continualClick(new RectangleDestination(getBot(), InventorySlotDestination.getSlot(from)),
				new Condition() {
					@Override
					public boolean evaluate() {
						if (toRec.contains(getMouse().getPosition()))
							return true;
						getMouse().move(new RectangleDestination(getBot(), toRec));
						return false;
					}
				});
	}

	// Script: Item Grinder
	// Requirements: 1x Pestal and Mortar (Bank Slot 9), 27x Regants.
	// Description: Crushes items into dust to resell.
	public void crush(String type, int amount) throws InterruptedException {
		itemCrushing = false;
		bank.open();
		main.sleep(main.random(200, 300));
		log(type + "s: " + bank.getAmount(type));

		if (bank.getAmount("Basket") >= 1 && bank.getAmount(type) >= 27) {
			log(type + "s: " + bank.getAmount(type));

			bank.open();
			main.sleep(main.random(200, 300));

			if (bank.isOpen()) {
				bank.depositAll();
				main.sleep(main.random(100, 200));

				bank.withdraw("Pestle and mortar", 1);
				main.sleep(main.random(100, 200));

				fillBank();
				main.sleep(main.random(100, 200));
				placeHolderRemover(75, 120, 105, 145);
				main.sleep(main.random(2000, 2000));
				fillBank();

				for (int i = 0; i < amount; i++) {
					bank.withdrawAll(type);
					main.sleep(main.random(100, 200));
					bank.close();

					moveInvItem(getInventory().getSlot(233), main.random(26, 27));

					main.sleep(main.random(100, 200));
					getInventory().interact(27, "Use");
					main.sleep(main.random(100, 200));

					getInventory().interact(26, "Use");
					main.sleep(main.random(20000, 30000));
					bank.open();
					main.sleep(main.random(100, 200));
					bank.depositAll();

				}

				itemCrushing = false;
				placeHolderRemover(75, 120, 105, 145);
				bank.depositAll();

			}

		} else {
			itemCrushing = false;
			placeHolderRemover(75, 120, 105, 145);
			bank.depositAll();
		}
	}

	// Script: Basket Filling
	// Requirements: 4x Baskets, 20x select Fruits.
	// Description: Fills baskets of fruit to resell.
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