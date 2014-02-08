Instructions to git setup...

Install git if you haven't... Good instructions on Google.

Pull down the repository to your machine:
git clone https://github.com/tardura/cs4624idealspreadsheet.git

You can do this in you home directory, etc. It will make a new folder
for the project.

cd into the directory, this is where you'll do work.

Run git branch.
It should return * master indicating you're on the master branch.
To make changes to the repository, we'll do so by branching off
master, making changes that are isolated from our master branch
and merging them when given an OK after code reviews.

How do I branch off?
git checkout -B <new branch name>

Now, run git branch.
It should show that you're on your new branch now.
Feel free to make changes. This allows us to make separate changes and merge them
separately with our master branch.

Check the status of your changes by running:
git status - list of files you've changed
git diff <file(s)> - gives line by line changes of each file or specified files

Now, let's say you have changes. There are two ways to make commits.
Commits should be task oriented in eye of the pull request.
When you've made enough changes to make a concise commit, either add
files to commit or you can add and commit at the same time:

git add <file(s)> - selective add
git commit -m "<message>"

OR

git commit -am "<message>" - adds all

Let's say you finish your pull request and have enough commits to submit your
PR for review. You need to push up your branch.
Run: git push origin <your branch name>
Goto: github.com and select our repo in the <> code section.
There should be a button to compare and review request.
Click that then submit your pull request.
