import javax.sound.midi.*;

public class MuzaTester {
    public void play() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            System.out.println("We've got sequencer");
            sequencer.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);

            Track track = seq.createTrack();

            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, 44, 100);
            MidiEvent noteP = new MidiEvent(a, 1);
            track.add(noteP);

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, 44, 100);
            MidiEvent noteK = new MidiEvent(b, 16);
            track.add(noteK);

            sequencer.setSequence(seq);
            sequencer.start();

        } catch (Exception ex) {ex.printStackTrace();}
            System.out.println("There is a problem");

        }


    public static void main(String[] args) {
        MuzaTester mt = new MuzaTester();

        mt.play();
    }
}
