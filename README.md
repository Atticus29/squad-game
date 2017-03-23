# _squad_

#### _squad, 03-23-2017_

#### By _**Janek Brandt and Mark Fisher**_

## Description
_Example text for the description of the project_


## Specifications

| Behavior                   | Input Example     | Output Example    |
| -------------------------- | -----------------:| -----------------:|
| user is able to create a hero | hero | hero |
| features of a hero (name, age, special power, attack rating, defense rating) are returned|Spiderman, 32, web slinging, 10, 7|Spiderman, 32, web slinging, 10, 7|
| user can create a new squad|squad| squad|
| squad returns name, max size, and cause|Avengers, 7, grossing billions of dollars in the box office|Avengers, 7, grossing billions of dollars in the box office|
|user can add heroes to a squad|add spiderman to Avengers|Spiderman added to Avengers|
|user prevented from adding hero to squad if squad is max size|add hulk to Avengers|definitely no room for Hulk|
|a hero can't be added to more than one squad|add spiderman to x-men|1) spiderman already in avengers 2) spiderman doesn't have the X gene|
|user can get summary of a squad|Avengers|Name: avengers, current group size: 6, cause: grossing billions of dollars in the box office, combined attack power: lots, combined defense power: lots, but not as much as attack|
|user can remove a hero from a squad|Remove spiderman from Avengers|Spiderman now a free agent, Avengers current size is 5|


## Setup/Installation Requirements

* _Clone the repository_
* _Run the command 'gradle run'_
* _Open browser and go to localhost:4567_


### License

Copyright (c) 2017 **_Janek Brandt and Mark Fisher_**

This software is licensed under the MIT license.
