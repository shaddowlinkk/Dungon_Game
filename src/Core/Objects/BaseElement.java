package Core.Objects;

import Core.Abstracts.StandardCollidableObject;

public class BaseElement extends StandardCollidableObject {
    public BaseElement(String Filename){
        setTexture("Elements\\"+Filename);
    }
    public BaseElement(){
    }
}
