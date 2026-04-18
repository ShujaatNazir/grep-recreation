<h1>MyGrep Documentation</h1>
<p>A Professional Java Command-Line Utility</p>
</div>

<h2>Overview</h2>
<p>A lightweight, recursive command-line utility built in Java that searches for specific keywords within all files in a directory tree. This tool mimics the basic functionality of the Linux <code>grep</code> command, providing a streamlined way to locate text across complex project structures.</p>

<h2>Features</h2>
<ul>
    <li><strong>Recursive Search:</strong> Automatically drills down into all subdirectories from a given root path.</li>
    <li><strong>Line-by-Line Reporting:</strong> Identifies the exact line number where a match is found.</li>
    <li><strong>Memory Efficient:</strong> Uses recursive path collection followed by streamlined file scanning.</li>
    <li><strong>Linux Integration:</strong> Designed to be packaged as a JAR and used as a global alias.</li>
</ul>

<h2>Installation & Setup</h2>
<h3>1. Build the Project</h3>
<p>Navigate to the project root and use Maven to package the application:</p>
<pre>mvn clean package</pre>

<h3>2. Global Accessibility</h3>
<pre>
mkdir -p ~/bin
cp target/mygrep-1.0-SNAPSHOT.jar ~/bin/findword.jar
echo "alias findword='java -jar ~/bin/findword.jar'" >> ~/.zshrc
source ~/.zshrc</pre>

<h2>Usage</h2>
<p>Run the tool by providing a target directory and the keyword you wish to find:</p>
<pre>findword &lt;path_to_directory&gt; &lt;keyword&gt;</pre>

<h3>Example:</h3>
<pre>findword . "DatabaseConnection"</pre>

<h2>Technical Implementation</h2>
<p>The core logic utilizes <code>java.io.File</code> for filesystem navigation and <code>java.util.Scanner</code> for buffered file reading. The recursion handles infinite directory depth while <code>try-with-resources</code> ensures safe file handle management.</p>
</body>
</html>
"""
