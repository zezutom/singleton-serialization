A sample output. Please observe how the persisted instance is being replaced by the latest state.

 Foo constructor

 Bar constructor, x = 1

 CREATED:		Bar{x=1}

 MODIFIED:		Bar{x=2}

 SERIALIZED:		Bar{x=2}

 MODIFIED:		Bar{x=3}

 Foo constructor

 read resolve

 DESERIALIZED:	Bar{x=3}

 MODIFIED:		Bar{x=4}

 SERIALIZED:		Bar{x=4}

 MODIFIED:		Bar{x=5}

 Foo constructor

 read resolve

 DESERIALIZED:	Bar{x=5}
