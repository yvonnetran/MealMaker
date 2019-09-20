README.txt

Version 5
- Very similar UI to HW2 and HW3
- Add button adds a new Ingredient to the list
- Created a ResultActivity class which opens up another activity
- Linked the btnResult to the ResultActivity class
- Created an activity_result XML file
- API has been set up
- Made a search algorithm
  
  < BUG > 
  The app is able to work properly when app is running,
  but there is a small problem when the emulator is restarted.
  The state of the list of Ingredients is saved even after the
  emnulator is restarted, so each ingredient_row in the View is
  still present when you restart the app. However, the list of
  ingredient name Strings is cleared. Therefore, deteling ingredients
  from a previous state causes the app to crash, and adding ingredients
  to a previous state would cause a UX/UI problem.

Next steps
- Fix the bug described above.
- update the UI of activity_result
- add more result information (e.g. recipe, calories, image(?)) to 
  RecipeActivity

Future steps (if possible)
- Show more than 1 result output (show 3-5 cards in the ResultActivity) with
  horizontal scrolling