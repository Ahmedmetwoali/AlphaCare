Implemented Use Case
First Use Case - Identify Hotspots, Authentication
Second Use Case - Export Data
Third Use Case - Prescriptions
Fourth Use Case - Data Input

Login Credentials
"Happy123", "Qwerty321"

If "", "" works then the test login is active please comment it out.


Refactoring Plan

Inconsistent MVC Pattern (Corrected): Everyone has made an effort to make the program consistent to the MVC architecture. Noticable changes would be found in the ControllerCore and seperate packages for each use case.

Main Menu Button: Each module contains a main menu button implemented or in the works to promote navigation between different parts of the program.

Unused Imports: Each member is making an effort to clear up any unused imports as they work on the program. The yellow underlines provided by NetBeans give us a clear idea what to look out for. Currently, Todd's and Lin's module applies to this refactoring plan. The remainder is work in progress due to some difficulties provided by Github branch merging (push and pulls).

Lack of Comments: Leslin's (Lin's) module, Export Data, was a clear sign of little to no comments. Comments have been to my module as I continue to look for improvements or changes so others can read and follow my code easier. Minor to medium improvements made in the Export Data package. Commenting is still work in progress. Trying to avoid redundancy but also be thorough.

Uncalled Methods w/n Some Classes: I spoke with Ahmed and Perry on this but there might be more areas of the program with this issue. This can account getters and setters plus created methods. This will be hard to point out but currently packages like IdentifyHotSpots and ExportData currently show an example of this optimization.

Couplers: Lin's module is an example of maintaining UI consistency. She does not create a seperate Stage but she does with Scenes. The use of seperate but identical Scenes maintain UI layout consistency while promoting component organization. She uses two kinds of scenes to hold two different layouts. She swaps between the two with the most appropriate stage to work with.

Bloaters: This relates to the unused imports and uncalled methods. Each member is trying to avoid such mistakes by communicating with others and finding solutions together.

Uncontrolled Login: ControllerCore possesses a boolean if statement to regulate the use and interaction of the Authentication module. The Authentication module would be switched off after the login is successful Lin and Selwyn worked on this module.

Stage-Scene Optimization: Each class is being considered to go through this plan for efficiency. Todd's module performs this well by using its own Stage instance and closes it when called to go back to the main menu. Lin's module would operate within the ControllerCore to set the scene according to which module she wants to be active. Additional scenes would be created on a seperate Stage to avoid coding or logical complications.
-PrimaryStage called in other modules can show a bit of advantage working as a seperate window with a closing function. Todd's module gives an example of this implementation.

MVC Architecture – (Class Variable: Bad Location): This plan was reflected well across all areas. Todd's module has already followed this protocol and Github retained old code which displayed old instances in bad places. Lin has expanded on this with her package by creating a controller for herself to modify her module more freely.