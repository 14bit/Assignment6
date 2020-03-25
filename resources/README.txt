Changes from last assignment:

- Added a name field to all shapes, since the AnimationBuilder expects shapes to be named.

- Changed model to look for names of shapes, rather than look for shapes based on index. To do this,
we also needed to change how we constructed shapes to avoid errors.

- Updated the model interface and model implementation to store information on the canvas.

- Added a setCanvas method to the model interface and model that sets up the canvas.

How our views work:

TODO: this