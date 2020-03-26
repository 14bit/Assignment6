------------------
Changes from last assignment:

- Added a name field to all shapes, since the AnimationBuilder expects shapes to be named.

- Changed model to look for names of shapes, rather than look for shapes based on index. To do this,
we also needed to change how we constructed shapes to avoid errors.

- Updated the model interface and model implementation to store information on the canvas.

- Added a setCanvas method to the model interface and model that sets up the canvas.

- Added a returnShapeList() method to the model interface and model so that the views can get access
to a copy of the shapeArrayList that the model stores in order to display its contents.

- Modified Shapes to check for time properly, as they were making sure time in movements didn't
overlap at all, rather than making sure movements had shared start and end points.

- Modified and removed some tests to reflect those changes

------------------
How our views work:

TODO: this