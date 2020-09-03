Hier we can list how to ?

# How to update a forked repo with git rebase

1.  git remote add upstream https://github.com/original-repo/goes-here.git
1.  git fetch upstream // Fetch all branches of remote upstream
1.  git rebase upstream/master
1.  git push origin master --force