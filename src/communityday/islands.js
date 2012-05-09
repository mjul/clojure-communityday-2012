// Javascript sorting by a property is a lot of work

var confs = [{name : "Clojure Conj", year : 2011 },
	     {name : "Community Day", year : 2012 }];

var sorted = confs.sort(function(a, b) {
 if (a.name < b.name) //sort string ascending
  return -1 
 if (a.name > b.name)
  return 1
 return 0 //default return value (no sorting)
});

print("Confs:");
print(JSON.stringify(confs));
print("Sorted:");
print(JSON.stringify(sorted));


