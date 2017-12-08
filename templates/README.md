# Test Unit Job description

TUJ is a Talend job that test one facet of one component. It is the unit test for Talend components. TUJs are executed on TTP (Test Talend Platform). There are several TTP to test components/studio with different versions of java. Currently we have some: https://tuj.talend.com/ (only 1.7 and 1.8 Oracle are maintened).

## What is it made of ?
A TUJ is mainly composed of 4 parts:
1. Loading context
1. Execution of the component
1. Check the execution with some tests
1. Some cleaning if needed

### Loading context
The context is given by the TTP when the job is about to be executed. This is the `template.csv` file from tuj-config repository. So, if your TUJ need new context variable, they must be added inside this file : https://github.com/Talend/tuj-config/blob/tal-rd01/tuj-runner/conf/template.csv

Tuj-config repository is a private one. Only critical context variables must be added into template.csv, mostly credentials. This file is loaded within the tPreJob.

For other context variables, you can add a `context.csv` file into the root folder of your TUJ. It will be loaded too if it exists. Those local context files are created along with the TUJ.

_To remember:_
- Critical context keys : into `template.csv` from tuj-config private repository
- Other context : into context.csv in the root folder of the TUJ

### Execution of the component
Once the context is loaded, you have to create a job to test the facet you want of the component. Currently, test environments are shared between all TTPs. So to avoid conflicts, use the available `pid` String variable to identify what you generate. For example, the name of a user you add into a database should be `"name_"+pid` and so on...

If it is possible, create a job with only one instance of the component you want to test. Create as many TUJs as you have configuration to test.

Your execution should generate some data to be test in the next section.

_To remember:_
- Only on instance of the component you want to test if possible
- Use `pid` variable
- One TUJ to test only one configuration

### Check the execution with some tests
Once your component has been executed and has generated some data, you have to use tAssert components to validate it. `tAssert` components will be caught by the `tAssertCatcher` which is provided into the template. So, all tests of the TUJ will be registered into the TTP Mysql database. You can have several tAssert in the same TUJ.

_To remember:_
- Use `tAssert` to test generated data
- All tests are registered into TTP

### Some cleaning if needed
If you have to some cleaning to do, like remove inserted tuple from the database or delete a generated file, you can do it within the tPostJob section.

There are two kind of cleaning:
1. Those which should be each time to not conflict with other TTP or if they can't help for analysis errors
1. Those which should not be do if the TUJ fails

Indeed, some generated files should not be deleted when a TUJ fails since it ca help to understand the issue. But, inserted rows should always be removed to avoid conflicts. If you think that inserted rows can be relevant for analysis, then export them into a csv file which will be kept with TUJ log if it fails.

You could see a `if` connector in the template. It manages the optional deletions.

_To remember:_
- Post job section is dedicated to cleaning
- Some cleaning should not be do if the job fails

## How to design my own TUJ ?
To help you to design TUJs, a template has been created.

## Import the template into your studio
At the same level of this `README.md`, you will find the template for TUJ in standard folder. So:
- first clone the project
- Then, from your studio, execute 'Import items' and select 'standard' folder
- Check `standard_tuj_template` and import it
- Duplicate it to create your own TUJ, so that you can keep the template unchanged

## how to run the template
The template is a runnable TUJ. If you try to run it, it will fail since:
- The global context file defined by `param_file_path` doesn't exist in your local environment
- Neither the local context file defined by `context.getProperty("data_dir")+"/context.csv"`
You can create them. The first one must contain all context variable except `filename` which is into the local one.

Then configure your TUJ context `param_file_path` with the path to your gobal context file, and copy your local context file into the folder `data_dir + job_name`.

Then, you can  deactivate the `Colibri(tMysqlOutput_1)` component and execute the TUJ. 

## How to personalize
To personalize your TUJ:
1. Delete the `Main sub-job` component and create your own sub-job to test your component and generate files to test
1. Delete the `Unit tests sub-job` and add your own assertions
1. Delete the `Main clean sub-job` and add components to do everytime-clean
1. Delete the `Clean if succces sub-job` and add component to do clean if TUJ successful (be carreful to connect this last sub-job with a `trigger/Run if` and set the condition `(Boolean)globalMap.put("TUJ_SUCCESS", Boolean.FALSE)`)

