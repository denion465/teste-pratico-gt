import axios from 'axios';

const ACCESS_TOKEN_MAP = `access_token=${process.env.REACT_APP_ACCESS_TOKEN_MAP}`;
// Token da api Mapbox
export const apiMap = (local: string): void => {
  axios
    .get(
      `https://api.mapbox.com/geocoding/v5/mapbox.places/${local}.json?${ACCESS_TOKEN_MAP}`,
    )
    .then(res => res.data);
};
