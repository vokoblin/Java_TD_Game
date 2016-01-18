/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.Objects;

import src.Objects.UseCase.Object;
/**
 *
 * @author Vovaxs
 */
public class Box implements Object{
    private static boolean exists;

    public Box() {
        Box.exists = true;
    }
    
    @Override
    public void update(float delta) {
        
    }

    @Override
    public void render() {
        
    }

    @Override
    public boolean exists() {
        return Box.exists;
    }

    @Override
    public void destroy() {
        Box.exists = false;
    }
    
}
