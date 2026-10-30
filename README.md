**Pokémon Card Collection Application
CIS2232 Project**
---

**Development Team**

**Business Client:** Peter Logan

**Lead Developer:** Bivan Fedha

**Quality Control:** Yasir Al Muhib

**Description**
---
This web application allows users to manage a collection of Pokémon cards. Users can add Pokémon cards, view card information, search through their collection, and analyze card statistics. The application stores information about each Pokémon card including its type, hit points, attack information, evolution stage, and retreat cost.

The application also provides reporting functionality that allows users to generate reports based on Pokémon card types and analyze the cards within their collection.

**Color**
---
**Main Color:** Pokémon Blue

**Secondary Color:** Pokémon Yellow

**Required Fields**
---
id int Unique identifier for database table
enteredDateTime String Date and time entered into the application
cardName String Pokémon card name
cardType String Pokémon card type (Fire, Water, Grass, Electric, Psychic, etc.)
cardHitPoints int Hit Points (HP) of the Pokémon card
cardAttackName String Name of the Pokémon card attack
cardAttackDamage int Damage value of the attack
cardAttackCost int Energy cost required for the attack
cardStage int Evolution stage (0 = Basic, 1 = Stage 1, 2 = Stage 2)
cardRetreatCost int Energy cost required to retreat the Pokémon

**Calculation**
---
The application provides a Pokémon effectiveness calculation.

When a user selects a Pokémon card, the application compares that card against all other cards currently stored in the database.

**Defender Rating**
Strong Defender if the card's HP is greater than twice the average attack damage of all other cards.
Weak Defender if the card's HP is less than the average attack damage of all other cards.
Otherwise the card is considered an Average Defender.
**Attacker Rating**
Strong Attacker if the card's attack damage is greater than the average HP of all other cards.
Weak Attacker if the card's attack damage is less than half of the average HP of all other cards.
Otherwise the card is considered an Average Attacker.
The calculation results are displayed to the user after processing.

**Report Details**
---
**Pokémon Card Type Report**

Enter a Pokémon card type and the report will return all Pokémon cards that match the selected type.

**Report Input**

Pokémon Card Type

**Report Output**

On the report results page, show:
Card ID
Card Name
Card Type
Hit Points
Attack Name
Attack Damage
Attack Cost
Stage
Retreat Cost
Date Entered
Also display: Total Cards Found
Average Hit Points
Average Attack Damage
The report results will be displayed on screen and written to a file.
