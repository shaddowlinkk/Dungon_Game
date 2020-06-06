package Objects;

import Abstracts.StandardCollidableObject;

public class BaseElement extends StandardCollidableObject {
    public BaseElement(String Filename){
        setTexture("Elements\\"+Filename);
    }
    public BaseElement(){
    }
}
