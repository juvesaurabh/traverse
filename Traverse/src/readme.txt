How to run?
FileTraverse.java is the main class and it takes 2 command line arguments - FileTraverse <root-folderpath-to-traverse> <traverse-method>

The <traverse-method> can be bfs or dfs.

For example - FileTraverse /User/Music dfs
This will traverse the /User/Music folder through DFS.

What is the output like?
This program returns a console output with the first section returning a fullpath listing in the order of traversal followed by a detailed listing (with size in bytes and modified date) delimited by pipe(|)