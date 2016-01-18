/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.Objects.UseCase;

/**
 *
 * @author Vovaxs
 */
public interface Object {
    public void update(float delta);
    public void render();
    public boolean exists();
    public void destroy();
}
