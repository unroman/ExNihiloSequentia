package novamachina.exnihilosequentia.common.compat.kubejs;

import com.google.gson.JsonObject;
import dev.latvian.mods.kubejs.fluid.FluidStackJS;
import dev.latvian.mods.kubejs.util.ListJS;

public class FluidItemRecipeJS extends BaseRecipeJS {

  @Override
  public void create(ListJS args) {
    this.inputItems.add(this.parseIngredientItem(args.get(0)));
    this.outputItems.add(this.parseResultItem(args.get(1)));
    this.fluid((FluidStackJS) args.get(2));
  }

  private void fluid(FluidStackJS fluidStack) {
    JsonObject object = new JsonObject();
    object.addProperty("fluid", fluidStack.getId());
    this.json.add("fluid", object);
  }

  @Override
  public void deserialize() {
    this.inputItems.add(this.parseIngredientItem(this.json.get("input")));
    this.outputItems.add(this.parseResultItem(this.json.get("result")));
  }

  @Override
  public void serialize() {
    if(this.serializeInputs) {
      this.json.add("input", this.inputItems.get(0).toJson());
    }
    if(this.serializeOutputs) {
      this.json.add("result", this.outputItems.get(0).toJson());
    }
  }
}
