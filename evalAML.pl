:- multifile(clause1/2).

 readFile(X,N):- 
	     open(X,read,Str),
         read(Str,N), 
         close(Str).
 eval:- 

    readFile('edb.txt',X),

 assert(amlPredicates(
 [
 'sameRoleClassLib','sameRoleClass','sameInterfaceClass','sameSystemUnitClass',
 'eClassClassificationAtt','eClassVersionAtt','eClassIRDIAtt','sameAttribute'
 ]
 )),
 consult('semi1.pl'),
 consult('AML_rules.pl'),
 consult(X),
 %consult('d:/Deutch/development/Rules4AMLIntegration/resources/files/TestData.pl'),
 tdb.

 writePredicates:-

  readFile('output.txt',Z),
  open(Z,write,FileName),
 consult('writeRules.pl'),
 myWrite(FileName),close(FileName).             
 
