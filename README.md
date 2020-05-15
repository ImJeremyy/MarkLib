<h1>MarkLib</h1>
<p>
MarkLib is a library for Jeremy to make spigot plugins shorter and less clutered with repetable code.
Created by Jeremy Tubongbanua
</p>

<h2>Creating Commands</h2>
<p>
<ol>
<li>Create command class that extends MCommand</li>
<li>Call the super constructor</li>
<li>Put code in overriden execute()</li>
<li>Add command with super.addCommand(MCommand) in main class of registerCommands().</li>
</ol>
</p>

<h2>Creating Listeners</h2>
<p>
<ol>
<li>Create listener class that extends MListener</li>
<li>Add listener with super.addListener(MListener) in main class of registerListeners().</li>
</ol>
</p>

<h2>Creating Configs</h2>
<p>
<ol>
<li>Create Config class that extends MConfig</li>
<li>Call super constructor</li>
<li>Fill push() with code that pushes cache to file</li>
<li>Fill pull() with code that pulls file into cache</li>
<li>Fill defaultConfig() with code using super.addDefault(path, value) so that the config can have default values.</li>
<li>Add config with super.addConfig(config) in registerConfigs() in main class</li>
</ol>
</p>

<h2>Creating Tables and Running Queries</h2>
<p>
<ol>
<li>Create Database class that extends MDatabase (requires host, dbName, port, user, pass)</li>
<li>Call super constructore</li>
<li>Fill defaultDatabase() with code that will check and create blank tables</li>
<li>Create methods within your class using createStatement(), prepareStatement(), MySQLUtil.getLines(ResultSet)</li>
</ol>

<h3>Query examples</h3>

```mysql
CREATE TABLE `players` (
	`uuid` VARCHAR(16) NOT NULL PRIMARY KEY, -- unique user id (player.getUniqueId().toString())
	`name` VARCHAR(16) NOT NULL,
	`joined_timestamp` TIMESTAMP NOT NULL DEFAULT(CURRENT_TIMESTAMP),
	`bio` VARCHAR(64) NULL
	);
	
CREATE TABLE `backup` SELECT * FROM `players`;
DROP TABLE `accounts_backup`;
DELETE FROM `players` WHERE `name` = 'DimSumPotato';
UPDATE players SET hello='2' WHERE username='DimSumPotato';
INSERT INTO `players` (`uuid`, `name`) VALUES ('123-456', 'MarkIsCool');
```
<p>
(Yes I know it doesn't match up but you can figure it out).
</p>

<h2>Creating NPCs</h2>

<h2>Packets and stuff</h2>

<h2>GUIs</h2>
