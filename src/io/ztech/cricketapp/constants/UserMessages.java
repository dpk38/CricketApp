package io.ztech.cricketapp.constants;

public class UserMessages {
	private UserMessages() {}
	
	public static final String ENTER_FIRST_NAME = "\nEnter first name: ";
	public static final String ENTER_LAST_NAME = "\nEnter last name: ";
	public static final String ENTER_USER_NAME = "\nEnter user name: ";
	public static final String ENTER_TEAM_NAME = "\nEnter team name: ";
	public static final String ENTER_NEW_NAME = "\nEnter the updated name: ";
	public static final String ENTER_TEAM_ID = "\nEnter team id: ";
	public static final String ENTER_LINE_UP = "\nEnter line up number: ";
	public static final String ENTER_PASSWORD = "\nEnter password: ";
	
	public static final String INVALID_NAME = "\nInvalid name entered!";
	public static final String INVALID_FIRST_NAME = "\nInvalid first name entered!";
	public static final String INVALID_LAST_NAME = "\nInvalid last name entered!";
	public static final String INVALID_CHOICE = "\nInvalid choice selected!";
	public static final String INVALID_NAME_EXCEPTION = "\nInvalid name exception caught. Please retry!";
	public static final String INCORRECT_PASSWORD = "\nThe password you have entered is incorrect. Please try again!";
	public static final String NO_SUCH_USER = "\nNo such user exists! Press (1) to sign up or (2) to retry: ";
	public static final String NO_SUCH_TEAM = "\nNo such team exists! Retry ";
	public static final String NO_SUCH_PLAYER = "\nNo such player exists! Retry ";
	
	public static final String MAIN_MENU = "(1) Matches\n(2) Teams\n(3) Players\n(4) Exit\nEnter choice: ";
	public static final String PLAYER_MENU = "\n(1) View Players\n(2) Edit Player\n(3) Create Player\nEnter choice: ";
	public static final String TEAM_MENU = "\n(1) View Teams\n(2) Edit Team\n(3) Create Team\nEnter choice: ";
	public static final String EDIT_TEAM_MENU = "\n(1) Change Team Name\n(2) Add Player\n(3) Remove Player\nEnter choice: ";
	public static final String EDIT_PLAYER_MENU = "\n(1) Player Team\n(2) First Name\n(3) Last Name\nWhich field do you wish to alter: ";
	public static final String MATCH_MENU = "\n(1) Play Match\n(2) View Matches\n(3) Edit Match\n(4) Create Match\nEnter choice: ";
	
	public static final String CONTINUE = "\nDo you wish to continue to main menu (y/n)? ";
	public static final String CONTINUE_PLAYER = "\nDo you wish to continue to players menu (y/n)? ";
	public static final String CONTINUE_TEAM = "\nDo you wish to continue to team menu (y/n)? ";
	public static final String CONTINUE_MATCH = "\nDo you wish to continue to match menu (y/n)? ";
	public static final String ADD_ANOTHER = "\nDo you wish to add another (y/n)? ";
	public static final String FURTHER_CHANGES = "\nDo you wish to make further changes (y/n)? ";
	
	public static final String TEAM_TABLE = "\nID\tName\n--------------";
	public static final String PLAYER_TABLE = "\nTeam\tID\tFirstName\tLastName\n-----------------------------------------";
	
	public static final String CREATING_PLAYERS = "\nCreating players:\n------------------";
	public static final String USER_ALREADY_EXISTS= "\nUser already exists. Try a different user name!";
	public static final String CHOOSE_TEAM = "\nChoose a team from the following. Enter team ID: ";
	public static final String CHOOSE_PLAYER = "\nChoose a player from the following. Enter player ID: ";
	public static final String SELECT_NEW_TEAM_ID = "\nSelect a new team ID for the player";
}

