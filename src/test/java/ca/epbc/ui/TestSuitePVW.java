package ca.epbc.ui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


    @RunWith(Suite.class)
    @Suite.SuiteClasses({


            AddRolePVW.class,
            AssignPermFeeAllActionPVW.class,
            CheckRolesPVW.class,
            CheckUserPVW.class,
            DeleteRolePVW.class,
            EditRolePVW.class,
            EditUserPVW.class,
            LoginPVW.class,
            CheckActionsPVW.class,
            CheckCategPVW.class,
            LoadInstitPVW.class,
            SelectSkookPVW.class,

        }
    )

    public class TestSuitePVW {

        @Test
        public void test() throws Exception {

        }
}
