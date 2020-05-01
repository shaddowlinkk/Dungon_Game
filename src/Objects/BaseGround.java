package Objects;

import Abstracts.StandardCollidableObject;

public class BaseGround extends StandardCollidableObject {
    public BaseGround(String Filename){
        setTexture("Ground\\"+Filename);
    }
}
