import React from 'react';
import { Route, Switch } from 'react-router-dom';

import CreatePatient from '../pages/CreatePatient';
import Home from '../pages/Home';
import Map from '../pages/Map';

const Routes: React.FC = () => (
  <Switch>
    <Route path="/" exact component={Home} />
    <Route path="/createpatient" exact component={CreatePatient} />
    <Route path="/map" exact component={Map} />
  </Switch>
);

export default Routes;
