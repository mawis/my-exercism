hello_world(Greeting) :-
	hello_world("World", Greeting).

hello_world(Person, Greeting) :-
	format(atom(Greeting), 'Hello ~w!', [Person]).
