import {
  Container,
  Name,
  Tab,
  TabText,
  EditButton,
  Text,
} from './Profile.styled';
import userData from '../data/db';

import { faPen } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

function Profile() {
  return (
    <Container>
      <Name>{userData[0].username}</Name>
      <EditButton>
        <FontAwesomeIcon icon={faPen} />
        <Text>Edit profile</Text>
      </EditButton>
      <Tab>
        <TabText>Profile</TabText>
        <TabText>Activity</TabText>
        <TabText>Saves</TabText>
        <TabText>Settings</TabText>
      </Tab>
    </Container>
  );
}
export default Profile;
