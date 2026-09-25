Project Group
BA / Business Client	- Peter Logan
Developer	            - Bivan
Project Manager / QA	- Yasir

Project Title
Pokémon Trading Card Application


Project Base Color
GoldenRod


Description (300 words)
Allows the user to add, remove and sort Pokémon cards based on their numerical data. Cards have a Hit Points stat, a Type, an attack with a Damage Value and Energy Cost, a Stage value (Basic 0, 1 or 2), and a Retreat cost. If a card has multiple attacks, only the attack with the highest value needs to be entered. User can evaluate strength of card relative to other cards in database.

 
Example
id	1
enteredDateTime	10:35 17th September 2026
cardName	Charizard
cardType	Fire
cardHitPoints	150
cardAttackName	Fire Spin
cardAttackDamage	200
cardAttackCost	4
cardStage	2
cardRetreatCost	3


Fields
Name	Data Type	Description
Id	int	Unique Identifier for database table
enteredDateTime	String	Date entered in application
cardName	String	Name of Pokémon
cardType	String	Elemental type of card
cardHitPoints	int	HP of card
cardAttackName	String	Name of first attack
cardAttackDamage	int	Damage value of attack
cardAttackCost	int	Energy cost of attack
cardStage	int	Stage value of Pokémon (0 for Basic, 1 for Stage 1, 2 for Stage 2)
cardRetreatCost	Int	Number of energy in retreat cost


Calculation
The user can select one of the cards in the list and determine its effectiveness. If their Hit Points are greater than double the average Attack Damage of all other cards, it will display “Strong Defender”. If their Attack Damage is greater than the average Hit Points of all other cards, it will display “Strong Attacker”. If the Hit Points is less the average attack damage of all other cards, it will display “Weak Defender”. If the Attack Damage is less than half the average Hit Points of all other cards, it will display “Weak Attacker”. Otherwise, it will display “Average Defender”/ “Average Attacker”.

