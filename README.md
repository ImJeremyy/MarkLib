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
<p>Coming soon</p>