package Main;

import datatype.Box;
import datatype.ColorObject;
import interfaces.ICamera;
import interfaces.IFoot;
import interfaces.IHand;

@SuppressWarnings("all")
public abstract class Robot {
  public interface Requires {
    /**
     * This can be called by the implementation to access this required port.
     * 
     */
    public ICamera eye();
  }
  
  public interface Component extends Robot.Provides {
  }
  
  public interface Provides {
    /**
     * This can be called to access the provided port.
     * 
     */
    public IHand hand();
    
    /**
     * This can be called to access the provided port.
     * 
     */
    public IFoot foot();
  }
  
  public interface Parts {
  }
  
  public static class ComponentImpl implements Robot.Component, Robot.Parts {
    private final Robot.Requires bridge;
    
    private final Robot implementation;
    
    public void start() {
      this.implementation.start();
      this.implementation.started = true;
    }
    
    protected void initParts() {
      
    }
    
    private void init_hand() {
      assert this.hand == null: "This is a bug.";
      this.hand = this.implementation.make_hand();
      if (this.hand == null) {
      	throw new RuntimeException("make_hand() in Main.Robot should not return null.");
      }
    }
    
    private void init_foot() {
      assert this.foot == null: "This is a bug.";
      this.foot = this.implementation.make_foot();
      if (this.foot == null) {
      	throw new RuntimeException("make_foot() in Main.Robot should not return null.");
      }
    }
    
    protected void initProvidedPorts() {
      init_hand();
      init_foot();
    }
    
    public ComponentImpl(final Robot implem, final Robot.Requires b, final boolean doInits) {
      this.bridge = b;
      this.implementation = implem;
      
      assert implem.selfComponent == null: "This is a bug.";
      implem.selfComponent = this;
      
      // prevent them to be called twice if we are in
      // a specialized component: only the last of the
      // hierarchy will call them after everything is initialised
      if (doInits) {
      	initParts();
      	initProvidedPorts();
      }
    }
    
    private IHand hand;
    
    public IHand hand() {
      return this.hand;
    }
    
    private IFoot foot;
    
    public IFoot foot() {
      return this.foot;
    }
  }
  
  public static class BrainRobot {
    public interface Requires {
    }
    
    public interface Component extends Robot.BrainRobot.Provides {
    }
    
    public interface Provides {
    }
    
    public interface Parts {
    }
    
    public static class ComponentImpl implements Robot.BrainRobot.Component, Robot.BrainRobot.Parts {
      private final Robot.BrainRobot.Requires bridge;
      
      private final Robot.BrainRobot implementation;
      
      public void start() {
        this.implementation.start();
        this.implementation.started = true;
      }
      
      protected void initParts() {
        
      }
      
      protected void initProvidedPorts() {
        
      }
      
      public ComponentImpl(final Robot.BrainRobot implem, final Robot.BrainRobot.Requires b, final boolean doInits) {
        this.bridge = b;
        this.implementation = implem;
        
        assert implem.selfComponent == null: "This is a bug.";
        implem.selfComponent = this;
        
        // prevent them to be called twice if we are in
        // a specialized component: only the last of the
        // hierarchy will call them after everything is initialised
        if (doInits) {
        	initParts();
        	initProvidedPorts();
        }
      }
    }
    
    /**
     * Used to check that two components are not created from the same implementation,
     * that the component has been started to call requires(), provides() and parts()
     * and that the component is not started by hand.
     * 
     */
    private boolean init = false;;
    
    /**
     * Used to check that the component is not started by hand.
     * 
     */
    private boolean started = false;;
    
    private Robot.BrainRobot.ComponentImpl selfComponent;
    
    /**
     * Can be overridden by the implementation.
     * It will be called automatically after the component has been instantiated.
     * 
     */
    protected void start() {
      if (!this.init || this.started) {
      	throw new RuntimeException("start() should not be called by hand: to create a new component, use newComponent().");
      }
    }
    
    /**
     * This can be called by the implementation to access the provided ports.
     * 
     */
    protected Robot.BrainRobot.Provides provides() {
      assert this.selfComponent != null: "This is a bug.";
      if (!this.init) {
      	throw new RuntimeException("provides() can't be accessed until a component has been created from this implementation, use start() instead of the constructor if provides() is needed to initialise the component.");
      }
      return this.selfComponent;
    }
    
    /**
     * This can be called by the implementation to access the required ports.
     * 
     */
    protected Robot.BrainRobot.Requires requires() {
      assert this.selfComponent != null: "This is a bug.";
      if (!this.init) {
      	throw new RuntimeException("requires() can't be accessed until a component has been created from this implementation, use start() instead of the constructor if requires() is needed to initialise the component.");
      }
      return this.selfComponent.bridge;
    }
    
    /**
     * This can be called by the implementation to access the parts and their provided ports.
     * 
     */
    protected Robot.BrainRobot.Parts parts() {
      assert this.selfComponent != null: "This is a bug.";
      if (!this.init) {
      	throw new RuntimeException("parts() can't be accessed until a component has been created from this implementation, use start() instead of the constructor if parts() is needed to initialise the component.");
      }
      return this.selfComponent;
    }
    
    /**
     * Not meant to be used to manually instantiate components (except for testing).
     * 
     */
    public synchronized Robot.BrainRobot.Component _newComponent(final Robot.BrainRobot.Requires b, final boolean start) {
      if (this.init) {
      	throw new RuntimeException("This instance of BrainRobot has already been used to create a component, use another one.");
      }
      this.init = true;
      Robot.BrainRobot.ComponentImpl  _comp = new Robot.BrainRobot.ComponentImpl(this, b, true);
      if (start) {
      	_comp.start();
      }
      return _comp;
    }
    
    private Robot.ComponentImpl ecosystemComponent;
    
    /**
     * This can be called by the species implementation to access the provided ports of its ecosystem.
     * 
     */
    protected Robot.Provides eco_provides() {
      assert this.ecosystemComponent != null: "This is a bug.";
      return this.ecosystemComponent;
    }
    
    /**
     * This can be called by the species implementation to access the required ports of its ecosystem.
     * 
     */
    protected Robot.Requires eco_requires() {
      assert this.ecosystemComponent != null: "This is a bug.";
      return this.ecosystemComponent.bridge;
    }
    
    /**
     * This can be called by the species implementation to access the parts of its ecosystem and their provided ports.
     * 
     */
    protected Robot.Parts eco_parts() {
      assert this.ecosystemComponent != null: "This is a bug.";
      return this.ecosystemComponent;
    }
  }
  
  /**
   * Used to check that two components are not created from the same implementation,
   * that the component has been started to call requires(), provides() and parts()
   * and that the component is not started by hand.
   * 
   */
  private boolean init = false;;
  
  /**
   * Used to check that the component is not started by hand.
   * 
   */
  private boolean started = false;;
  
  private Robot.ComponentImpl selfComponent;
  
  /**
   * Can be overridden by the implementation.
   * It will be called automatically after the component has been instantiated.
   * 
   */
  protected void start() {
    if (!this.init || this.started) {
    	throw new RuntimeException("start() should not be called by hand: to create a new component, use newComponent().");
    }
  }
  
  /**
   * This can be called by the implementation to access the provided ports.
   * 
   */
  protected Robot.Provides provides() {
    assert this.selfComponent != null: "This is a bug.";
    if (!this.init) {
    	throw new RuntimeException("provides() can't be accessed until a component has been created from this implementation, use start() instead of the constructor if provides() is needed to initialise the component.");
    }
    return this.selfComponent;
  }
  
  /**
   * This should be overridden by the implementation to define the provided port.
   * This will be called once during the construction of the component to initialize the port.
   * 
   */
  protected abstract IHand make_hand();
  
  /**
   * This should be overridden by the implementation to define the provided port.
   * This will be called once during the construction of the component to initialize the port.
   * 
   */
  protected abstract IFoot make_foot();
  
  /**
   * This can be called by the implementation to access the required ports.
   * 
   */
  protected Robot.Requires requires() {
    assert this.selfComponent != null: "This is a bug.";
    if (!this.init) {
    	throw new RuntimeException("requires() can't be accessed until a component has been created from this implementation, use start() instead of the constructor if requires() is needed to initialise the component.");
    }
    return this.selfComponent.bridge;
  }
  
  /**
   * This can be called by the implementation to access the parts and their provided ports.
   * 
   */
  protected Robot.Parts parts() {
    assert this.selfComponent != null: "This is a bug.";
    if (!this.init) {
    	throw new RuntimeException("parts() can't be accessed until a component has been created from this implementation, use start() instead of the constructor if parts() is needed to initialise the component.");
    }
    return this.selfComponent;
  }
  
  /**
   * Not meant to be used to manually instantiate components (except for testing).
   * 
   */
  public synchronized Robot.Component _newComponent(final Robot.Requires b, final boolean start) {
    if (this.init) {
    	throw new RuntimeException("This instance of Robot has already been used to create a component, use another one.");
    }
    this.init = true;
    Robot.ComponentImpl  _comp = new Robot.ComponentImpl(this, b, true);
    if (start) {
    	_comp.start();
    }
    return _comp;
  }
  
  /**
   * This should be overridden by the implementation to instantiate the implementation of the species.
   * 
   */
  protected Robot.BrainRobot make_BrainRobot(final ColorObject color, final Box box) {
    return new Robot.BrainRobot();
  }
  
  /**
   * Do not call, used by generated code.
   * 
   */
  public Robot.BrainRobot _createImplementationOfBrainRobot(final ColorObject color, final Box box) {
    Robot.BrainRobot implem = make_BrainRobot(color,box);
    if (implem == null) {
    	throw new RuntimeException("make_BrainRobot() in Main.Robot should not return null.");
    }
    assert implem.ecosystemComponent == null: "This is a bug.";
    assert this.selfComponent != null: "This is a bug.";
    implem.ecosystemComponent = this.selfComponent;
    return implem;
  }
  
  /**
   * This can be called to create an instance of the species from inside the implementation of the ecosystem.
   * 
   */
  protected Robot.BrainRobot.Component newBrainRobot(final ColorObject color, final Box box) {
    Robot.BrainRobot _implem = _createImplementationOfBrainRobot(color,box);
    return _implem._newComponent(new Robot.BrainRobot.Requires() {},true);
  }
}
