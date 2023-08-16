import CollectivesWidget from './CollectivesWidget/CollectivesWidget';
import RelatedTags from './RelatedTags/RelatedTags';
import SideWidget from './SideWidget/SideWidget';
import { Container, SideBarZone } from './SideBar.styled';

function SideBar() {
  return (
    <Container>
      <SideWidget />
      <CollectivesWidget />
      <SideBarZone />
      <RelatedTags />
    </Container>
  );
}

export default SideBar;
