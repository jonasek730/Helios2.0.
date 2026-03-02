package Class;





class PlayerTest {

  //  @Test

   /*
   *   void addInventoryStopsAtCapacity() {
        Player player = new Player();
        for (int i = 1; i <= 5; i++) {
            assertEquals("Prvek byl sebrán.", player.addInventory(new Item("item" + i, "d")));
        }

        String result = player.addInventory(new Item("item6", "d"));

        assertEquals("Tvůj inventář je plný.", result);
        assertEquals(5, player.getInventory().size());
    }
    *  @Test
    void moveToRoomChangesCurrentRoom() {
        Room start = new Room();
        start.setName("Start");
        Room hangar = new Room();
        hangar.setName("Hangár");
        start.getAround().add(hangar);

        Player player = new Player("Hráč", start, 100);

        player.moveToRoom("hangár");

        assertEquals(hangar, player.getActualRoom());

*  @Test
    void checkInventoryUnlocksActualRoom() {
        Room room = new Room();
        room.setName("Obytná část");
        room.setAvailable(false);
        Player player = new Player("Hráč", room, 100);
        player.addInventory(new Item("Klíč od obytné místnosti", "otevře dveře"));

        player.checkInventory();

        assertTrue(room.isAvailable());
        assertEquals(1, player.getTask());
    }
    *   @Test
    void hangarDoorWithCode() {
        Player player = new Player("Hráč", new Room(), 100);
        Hangar hangar = new Hangar();
        hangar.setHangarcode(2048);
        Room laboratory = new Room();

        String result = player.hangarDoor(new Scanner("2048"), hangar, laboratory);

        assertEquals("Kód byl správný, odemkly se dveře do Hangáru i Laboratoří.", result);
        assertTrue(hangar.isAvailable());
        assertTrue(laboratory.isAvailable());
        assertEquals(2, player.getTask());
    }
    *  @Test
    void linkRoomsConnectsExistingNeighborsAndSkipsMissing() {
        Room a = new Room();
        a.setName("A");
        a.setAroundNames(List.of("B", "Missing"));

        Room b = new Room();
        b.setName("B");

        DataLoader loader = new DataLoader();
        loader.linkRooms(List.of(a, b));

        assertEquals(1, a.getAround().size());
        assertEquals("B", a.getAround().get(0).getName());
    }
*/
    }
