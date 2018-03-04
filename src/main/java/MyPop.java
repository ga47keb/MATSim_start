import org.matsim.api.core.v01.Coord;
import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.network.Link;
import org.matsim.api.core.v01.population.*;
import org.matsim.core.population.routes.RouteFactories;

public class MyPop {

    public Population syntheticPop (Population population){

        PopulationFactory populationFactory = population.getFactory();

        // starting plan of a person

        for (int mypersonid = 0; mypersonid < 5;mypersonid++) {
            Plan plan = populationFactory.createPlan();

            //creating a person
            Person person = populationFactory.createPerson(Id.createPersonId(mypersonid));

            // creating home activity
            Coord homecord = new Coord(4655474, 5315953);
            Activity homeactivity = populationFactory.createActivityFromCoord("home", homecord);
            homeactivity.setEndTime(8 * 3600 + Math.random() * 3600);

            plan.addActivity(homeactivity);
            plan.addLeg(populationFactory.createLeg("car"));


            // work activity
            Coord workcoord = new Coord(4615474, 5365953);
            Activity workactivity = populationFactory.createActivityFromCoord("work", workcoord);
            workactivity.setEndTime(16 * 3600 + Math.random() * 3600);

            plan.addActivity(workactivity);
            plan.addLeg(populationFactory.createLeg("car"));

            //shop activity
            Coord shopcoord = new Coord(4615000, 5366000);
            Activity shopactivity = populationFactory.createActivityFromCoord("shopping", shopcoord);
            shopactivity.setEndTime(18 * 3600 + Math.random() * 3600);

            plan.addActivity(shopactivity);
            plan.addLeg(populationFactory.createLeg("car"));

            //back to home
            //Coord homecord = new Coord(4655474, 5315953);
            Activity homeactivity2 = populationFactory.createActivityFromCoord("home", homecord);
            //homeactivity.setEndTime(8 * 3600 + Math.random() * 3600);

            plan.addActivity(homeactivity2);
            plan.addLeg(populationFactory.createLeg("car"));

            person.addPlan(plan);
            population.addPerson(person);

        }



        return population;



    }



}