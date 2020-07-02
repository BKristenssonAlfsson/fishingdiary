package se.njord.fishingdiary.unit.fish;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import se.njord.fishingdiary.domain.fish.FishController;

@RunWith(Arquillian.class)
public class FishTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(FishController.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
}
